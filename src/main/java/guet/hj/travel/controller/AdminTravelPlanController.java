package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.KindEditor;
import guet.hj.travel.entity.TravelPlan;
import guet.hj.travel.service.TravelPlanService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminTravelPlanController {
    @Autowired
    private TravelPlanService travelPlanService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @GetMapping("/travelPlan")
    public String travelPlan(){
        return "travelPlan-list";
    }

    @GetMapping("/travelPlanAdd")
    public String travelPlanAdd(){
        return"travelPlan-add";
    }

    @ResponseBody
    @GetMapping("/travelPlanList")
    public TableListVO<TravelPlan> travelPlanList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long planId = null;
        if (request.getParameter("planId") != null && !request.getParameter("planId").trim().equals("")){
            planId = Long.parseLong(request.getParameter("planId"));
        }
        String planAuthor = request.getParameter("planAuthor");
        String planTitle = request.getParameter("planTitle");
        List<TravelPlan> travelPlanList = travelPlanService.getTravelPlanList(planId, planAuthor, planTitle);
        PageInfo<TravelPlan> pageInfo = new PageInfo<>(travelPlanList);
        return new TableListVO<>(pageInfo.getTotal(), travelPlanList);
    }

    @ResponseBody
    @PostMapping("/travelPlan")
    public ResultVO travelPlanAdd(@RequestParam("img")MultipartFile img, TravelPlan travelPlan, HttpSession session){
        try {
            if (!img.isEmpty()) {
                travelPlan.setPlanImage(saveFile(img));
            }
            if (travelPlan.getPlanStatus() == null){
                travelPlan.setPlanStatus(0);
            }
            travelPlan.setPlanAuthor(session.getAttribute("loginUser").toString());
            travelPlan.setPlanSubmitTime(new Date());
            travelPlan.setPlanViewQuantity(0);
            travelPlanService.saveTravelPlan(travelPlan);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @PostMapping("/travelPlan/{planId}")
    public ResultVO travelPlanEdit(@RequestParam("img")MultipartFile img,@PathVariable("planId")Long planId, TravelPlan travelPlan, HttpSession session){
        try {
            if (!img.isEmpty()) {
                travelPlan.setPlanImage(saveFile(img));
            }
            if (travelPlan.getPlanStatus() == null){
                travelPlan.setPlanStatus(0);
            }
            travelPlan.setPlanId(planId);
            travelPlan.setPlanAuthor(session.getAttribute("loginUser").toString());
            travelPlan.setPlanSubmitTime(new Date());
            travelPlanService.editTravelPlan(travelPlan);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/travelPlan/{planId}")
    public String travelPlanEdit(@PathVariable("planId")Long planId, Model model){
        TravelPlan travelPlan = travelPlanService.getTravelPlan(planId);
        model.addAttribute("travelPlan", travelPlan);
        return "travelPlan-edit";
    }

    @ResponseBody
    @DeleteMapping("/travelPlan/{planId}")
    public ResultVO travelPlanDel(@PathVariable("planId")Long planId){
        try{
            travelPlanService.delTravelPlan(planId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/travelPlanDelBatch/{id_str}")
    public ResultVO cultureActivityDelBatch(@PathVariable("id_str")String id_str){
        try{
            travelPlanService.delBatchTravelPlan(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }


    @ResponseBody
    @RequestMapping("/travelPlan/image")
    public KindEditor image(@RequestParam("imgFile")MultipartFile file){
        KindEditor kindEditor = new KindEditor();
        try {
            kindEditor.setError(0);
            kindEditor.setUrl(saveFile(file));
        }catch (Exception e){
            kindEditor.setError(1);
        }
        return kindEditor;
    }

    private String saveFile(MultipartFile img) throws Exception{
        String fileName = img.getOriginalFilename();
        String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/image/travelPlan";
        folderPath = URLDecoder.decode(folderPath, "UTF-8");
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File dest = new File(folderPath + "/" + fileName);
        img.transferTo(dest);
        return fileRootPath + "/image/travelPlan/" + fileName;
    }
}
