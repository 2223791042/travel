package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.dto.NewsDTO;
import guet.hj.travel.enums.NewsEnum;
import guet.hj.travel.service.NewsService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 获取新闻列表内容
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public TableListVO<NewsDTO> list(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "5") int limit) {
        PageHelper.startPage(page, limit);
        Map<String, Object> map = newsService.getNewsDTOList(NewsEnum.RELEASE.getNewsStatus());
        PageInfo pageInfo = (PageInfo) map.get("pageInfo");
        List<NewsDTO> newsDTOList = (List<NewsDTO>)map.get("newsDTOList");
        return new TableListVO<>(pageInfo.getTotal(), newsDTOList);
    }

    /**
     * 根据id获取新闻详情
     * @param newsId
     * @return
     */
    @ResponseBody
    @GetMapping("/{newsId}")
    public ResultVO<NewsDTO> news(@PathVariable("newsId")Long newsId){
        NewsDTO newsDTO = newsService.getNewsDTO(newsId, NewsEnum.RELEASE.getNewsStatus());
        return ResultVOUtil.success(newsDTO);
    }
}
