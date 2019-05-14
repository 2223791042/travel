package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.CultureActivity;
import guet.hj.travel.service.CultureActivityService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cultureActivity")
public class CultureActivityController {
    @Autowired
    private CultureActivityService cultureActivityService;

    @ResponseBody
    @GetMapping("/list")
    public TableListVO<CultureActivity> list(int page, int limit){
        PageHelper.startPage(page, limit);
        List<CultureActivity> cultureActivityList = cultureActivityService.getCultureActivityList();
        PageInfo<CultureActivity> pageInfo = new PageInfo<>(cultureActivityList);
        return new TableListVO<>(pageInfo.getTotal(), cultureActivityList);
    }

    @ResponseBody
    @GetMapping("/list/{activityId}")
    public TableListVO<CultureActivity> list(@PathVariable("activityId")Long activityId){
        List<CultureActivity> cultureActivityList = cultureActivityService.getCultureActivityList(activityId);
        if (cultureActivityList == null){
            return new TableListVO<>(0L, null);
        }
        return new TableListVO<>((long)cultureActivityList.size(), cultureActivityList);
    }

    @ResponseBody
    @GetMapping("/{activityId}")
    public ResultVO cultureActivity(@PathVariable("activityId")Long activityId){
        return ResultVOUtil.success(cultureActivityService.getCultureActivity(activityId));
    }
}
