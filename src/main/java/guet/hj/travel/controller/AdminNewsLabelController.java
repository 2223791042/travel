package guet.hj.travel.controller;

import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.News;
import guet.hj.travel.entity.NewsLabel;
import guet.hj.travel.enums.ResultEnum;
import guet.hj.travel.service.NewsLabelService;
import guet.hj.travel.service.NewsService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminNewsLabelController {
    @Autowired
    private NewsLabelService newsLabelService;

    @Autowired
    private NewsService newsService;

    @ResponseBody
    @GetMapping("/newsLabelList")
    public ResultVO newsLabelList(){
        List<NewsLabel> newsLabelList = newsLabelService.getNewsLabelList();
        return ResultVOUtil.success(newsLabelList);
    }

    @GetMapping("/newsLabel")
    public String newsLabel(){
        return "newsLabel-list";
    }

    @GetMapping("/newsLabelAdd")
    public String newsLabelAdd(){
        return "newsLabel-add";
    }

    @GetMapping("/newsLabel/{labelId}")
    public String newsLabelEdit(@PathVariable("labelId")Integer labelId, Model model){
        NewsLabel newsLabel = newsLabelService.getNewsLabel(labelId);
        model.addAttribute("newsLabel", newsLabel);
        return "newsLabel-edit";
    }

    @ResponseBody
    @PutMapping("/newsLabel/{labelId}")
    public ResultVO newsLabelEdit(@PathVariable("labelId")Integer labelId, NewsLabel newsLabel,HttpSession session){
        try{
            String loginUser = (String) session.getAttribute("loginUser");
            newsLabel.setLabelId(labelId);
            newsLabel.setLabelAuthor(loginUser);
            newsLabelService.editNewsLabel(newsLabel);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("修改失败");
        }
    }

    @ResponseBody
    @DeleteMapping("/newsLabel/{labelId}")
    public ResultVO newsLabelDel(@PathVariable("labelId")Integer labelId){
        List<News> newsList = newsService.getNewsList(labelId);
        if (newsList.size() == 0){
            try{
                newsLabelService.delNewsLabel(labelId);
                return ResultVOUtil.success();
            }catch (Exception e){
                return ResultVOUtil.fail("删除失败");
            }
        }else {
            return ResultVOUtil.fail("由于该类型已绑定新闻无法删除！");
        }
    }

    @ResponseBody
    @GetMapping("/newsLabel/checkLabelName/{labelName}")
    public ResultVO checkTypeName(@PathVariable("labelName")String labelName){
        NewsLabel newsLabel = newsLabelService.getNewsLabel(labelName);
        if (newsLabel != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.fail("新闻标签重复");
    }

    @ResponseBody
    @PostMapping("/newsLabel")
    public ResultVO newsLabelAdd(NewsLabel newsLabel, HttpSession session){
        try{
            String loginUser = (String) session.getAttribute("loginUser");
            newsLabel.setLabelAuthor(loginUser);
            newsLabelService.saveNewsLabel(newsLabel);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("添加失败");
        }
    }


}
