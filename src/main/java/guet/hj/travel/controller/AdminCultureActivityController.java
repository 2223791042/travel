package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.CultureActivity;
import guet.hj.travel.entity.KindEditor;
import guet.hj.travel.service.CultureActivityService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
public class AdminCultureActivityController {
    @Autowired
    private CultureActivityService cultureActivityService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @GetMapping("/cultureActivity")
    public String cultureActivity(){
        return "cultureActivity-list";
    }

    @ResponseBody
    @GetMapping("/cultureActivityList")
    public TableListVO<CultureActivity> cultureActivityList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long activityId = null;
        if (request.getParameter("activityId") != null && !request.getParameter("activityId").trim().equals("")){
            activityId = Long.parseLong(request.getParameter("activityId"));
        }
        String activityAuthor = request.getParameter("activityAuthor");
        String activityTitle = request.getParameter("activityTitle");
        String activityLabel = request.getParameter("activityLabel");
        List<CultureActivity> cultureActivityList = cultureActivityService.getCultureActivityList(activityId, activityAuthor, activityTitle, activityLabel);
        PageInfo<CultureActivity> pageInfo = new PageInfo<>(cultureActivityList);
        return new TableListVO<>(pageInfo.getTotal(), cultureActivityList);
    }

    @GetMapping("/cultureActivityAdd")
    public String cultureActivityAdd(){
        return "cultureActivity-add";
    }

    @ResponseBody
    @PostMapping("/cultureActivity")
    public ResultVO cultureActivityAdd(@RequestParam("img")MultipartFile img, CultureActivity cultureActivity, HttpSession session){
        try {
            if (!img.isEmpty()) {
                cultureActivity.setActivityImage(saveFile(img));
            }
            if (cultureActivity.getActivityStatus() == null){
                cultureActivity.setActivityStatus(0);
            }
            cultureActivity.setActivityAuthor(session.getAttribute("loginUser").toString());
            cultureActivity.setActivitySubmitTime(new Date());
            cultureActivityService.saveCultureActivity(cultureActivity);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @RequestMapping("/cultureActivity/image")
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

    @GetMapping("/cultureActivity/{activityId}")
    public String cultureActivityEdit(@PathVariable("activityId")Long activityId, Model model){
        CultureActivity cultureActivity = cultureActivityService.getCultureActivity(activityId);
        model.addAttribute("cultureActivity", cultureActivity);
        return "cultureActivity-edit";
    }

    @ResponseBody
    @PutMapping("/cultureActivity/{activityId}")
    public ResultVO cultureActivityEdit(@RequestParam("img")MultipartFile img,@PathVariable("activityId")Long activityId, CultureActivity cultureActivity, HttpSession session){
        try {
            if (!img.isEmpty()) {
                cultureActivity.setActivityImage(saveFile(img));
            }
            cultureActivity.setActivityId(activityId);
            if (cultureActivity.getActivityStatus() == null) {
                cultureActivity.setActivityStatus(0);
            }
            cultureActivity.setActivityAuthor(session.getAttribute("loginUser").toString());
            cultureActivity.setActivitySubmitTime(new Date());
            cultureActivityService.editCultureActivity(cultureActivity);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/cultureActivity/{activityId}")
    public ResultVO cultureActivityDel(@PathVariable("activityId")Long activityId){
        try{
            cultureActivityService.delCultureActivity(activityId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/cultureActivityDelBatch/{id_str}")
    public ResultVO cultureActivityDelBatch(@PathVariable("id_str")String id_str){
        try{
            cultureActivityService.delBatchCultureActivity(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    private String saveFile(MultipartFile img) throws Exception{
        String fileName = img.getOriginalFilename();
        String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/image/cultureActivity";
        folderPath = URLDecoder.decode(folderPath, "UTF-8");
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File dest = new File(folderPath + "/" + fileName);
        img.transferTo(dest);
        return fileRootPath + "/image/cultureActivity/" + fileName;
    }
}
