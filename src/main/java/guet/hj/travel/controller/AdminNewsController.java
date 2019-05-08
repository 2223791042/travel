package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.dto.NewsDTO;
import guet.hj.travel.entity.KindEditor;
import guet.hj.travel.entity.News;
import guet.hj.travel.entity.NewsLabel;
import guet.hj.travel.enums.NewsEnum;
import guet.hj.travel.enums.ResultEnum;
import guet.hj.travel.service.NewsLabelService;
import guet.hj.travel.service.NewsService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminNewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsLabelService newsLabelService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @GetMapping("/news")
    public String news(){
        return "news-list";
    }

    @GetMapping("/newsAdd")
    public String newsAdd(Model model){
        List<NewsLabel> newsLabelList = newsLabelService.getNewsLabelList();
        model.addAttribute("newsLabelList", newsLabelList);
        return "news-add";
    }

    @ResponseBody
    @GetMapping("/newsList")
    public TableListVO<NewsDTO> newsList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long newsId = null;
        if (request.getParameter("newsId") != null){
            if (!request.getParameter("newsId").trim().equals(""))
                newsId  = Long.parseLong(request.getParameter("newsId"));
        }
        String newsAuthor = request.getParameter("newsAuthor");
        String newsTitle = request.getParameter("newsTitle");
        Integer newsLabelId = null;
        if (request.getParameter("newsLabelId") != null){
            if (!request.getParameter("newsLabelId").trim().equals(""))
                newsLabelId  = Integer.parseInt(request.getParameter("newsLabelId"));
        }
        Map<String, Object> map = newsService.getNewsDTOList(newsId, newsAuthor, newsTitle, newsLabelId);
        PageInfo pageInfo = (PageInfo) map.get("pageInfo");
        List<NewsDTO> newsDTOList = (List<NewsDTO>)map.get("newsDTOList");
        return new TableListVO<>(pageInfo.getTotal(), newsDTOList);
    }

    @GetMapping("/news/{newsId}")
    public String newsEdit(@PathVariable("newsId")Long newsId, Model model){
        NewsDTO newsDTO = newsService.getNewsDTO(newsId);
        List<NewsLabel> newsLabelList = newsLabelService.getNewsLabelList();
        model.addAttribute("news", newsDTO);
        model.addAttribute("newsLabelList", newsLabelList);
        return "news-edit";
    }

    @ResponseBody
    @GetMapping("/news/checkNewsTitle/{newsTitle}")
    public ResultVO checkNewsTitle(@PathVariable("newsTitle") String newsTitle){
        News news = newsService.getNews(newsTitle);
        if (news != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.fail("新闻标题未重复");
    }

    @ResponseBody
    @PostMapping("/news/{type}")
    public ResultVO newsAdd(@PathVariable("type") String type, @RequestParam("img")MultipartFile img,
                            News news, HttpSession session){
        try{
            if(!img.isEmpty()){
                String fileName = img.getOriginalFilename();
                String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/image/news";
                folderPath = URLDecoder.decode(folderPath, "UTF-8");
                File folder = new File(folderPath);
                if(!folder.exists()){
                    folder.mkdirs();
                }
                File dest = new File(folderPath +"/" + fileName);
                img.transferTo(dest);
                String imageUrl = fileRootPath + "/image/news/"+fileName;
                news.setNewsImage(imageUrl);
            }
            if(type.equals("save")){
                news.setNewsStatus(NewsEnum.SAVE.getNewsStatus());
            }
            if(type.equals("release")){
                news.setNewsStatus(NewsEnum.RELEASE.getNewsStatus());
            }
            news.setNewsAuthor(session.getAttribute("loginUser").toString());
            newsService.saveNews(news);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("添加失败");
        }
    }

    @ResponseBody
    @PutMapping("/news/{newsId}")
    public ResultVO newsEdit(News news, @PathVariable("newsId")Long newsId, @RequestParam("img")MultipartFile img,String type, HttpSession session){
        try{
            if(!img.isEmpty()){
                String fileName = img.getOriginalFilename();
                String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/image/news";
                folderPath = URLDecoder.decode(folderPath, "UTF-8");
                File folder = new File(folderPath);
                if(!folder.exists()){
                    folder.mkdirs();
                }
                File dest = new File(folderPath +"/" + fileName);
                img.transferTo(dest);
                String imageUrl = fileRootPath + "/image/news/"+fileName;
                news.setNewsImage(imageUrl);
            }
            news.setNewsAuthor(session.getAttribute("loginUser").toString());
            news.setNewsId(newsId);
            newsService.editNews(news, type);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("修改失败");
        }
    }

    @ResponseBody
    @DeleteMapping("/news/{newsId}")
    public ResultVO newsDel(@PathVariable("newsId")Long newsId){
        try{
            newsService.delNews(newsId);
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
        return ResultVOUtil.success();
    }

    @ResponseBody
    @DeleteMapping("/newsDelBatch/{id_str}")
    public ResultVO newsDelBatch(@PathVariable("id_str") String id_str){
        try{
            newsService.delBatchNews(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("/news/image")
    public KindEditor image(@RequestParam("imgFile")MultipartFile file){
        String fileName = file.getOriginalFilename();
        String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/image/news";
        KindEditor kindEditor = new KindEditor();
        try {
            folderPath = URLDecoder.decode(folderPath, "UTF-8");
            File folder = new File(folderPath);
            if(!folder.exists()){
                folder.mkdirs();
            }
            File dest = new File(folderPath +"/" + fileName);
            file.transferTo(dest);
            kindEditor.setError(0);
            kindEditor.setUrl(fileRootPath + "/image/news/"+fileName);
        }catch (Exception e){
            kindEditor.setError(1);
        }
        return kindEditor;
    }


}
