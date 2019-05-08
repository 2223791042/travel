package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.Suggest;
import guet.hj.travel.service.SuggestService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminSuggestController {
    @Autowired
    private SuggestService suggestService;

    @GetMapping("/suggest")
    public String suggest(){
        return "suggest-list";
    }

    @ResponseBody
    @GetMapping("/suggestList")
    public TableListVO<Suggest> suggestList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Date startTime = null;
        Date endTime = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            startTime = dateFormat.parse(request.getParameter("startTime"));
        }catch (Exception e){
        }
        try {
            endTime = dateFormat.parse(request.getParameter("endTime"));
        }catch (Exception e){

        }
        String title = request.getParameter("title");
        List<Suggest> suggestList = suggestService.getSuggestList(startTime, endTime, title);
        PageInfo<Suggest> pageInfo = new PageInfo<>(suggestList);
        return new TableListVO<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/suggest/{suggestId}")
    public String look(@PathVariable("suggestId")Long suggestId, Model model){
        Suggest suggest = suggestService.getSuggest(suggestId);
        model.addAttribute("suggest", suggest);
        return "suggest-look";
    }


    @ResponseBody
    @DeleteMapping("/suggestDelBatch/{id_str}")
    public ResultVO suggestDelBatch(@PathVariable("id_str") String id_str){
        try{
            suggestService.delBatchSuggest(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

    @ResponseBody
    @DeleteMapping("/suggest/{suggestId}")
    public ResultVO suggestDel(@PathVariable("suggestId") Long suggestId){
        try{
            suggestService.delSuggest(suggestId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

}
