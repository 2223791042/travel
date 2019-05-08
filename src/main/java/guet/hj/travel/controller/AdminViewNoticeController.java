package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.KindEditor;
import guet.hj.travel.entity.ViewNotice;
import guet.hj.travel.enums.ViewNoticeEnum;
import guet.hj.travel.service.ViewNoticeService;
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
public class AdminViewNoticeController {
    @Autowired
    private ViewNoticeService viewNoticeService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @GetMapping("/viewNotice")
    public String viewNotice(){
        return "viewNotice-list";
    }

    @ResponseBody
    @GetMapping("/viewNoticeList")
    public TableListVO<ViewNotice> viewNoticeList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long noticeId = null;
        if(request.getParameter("noticeId") != null){
            if (!request.getParameter("noticeId").trim().equals(""))
                noticeId = Long.parseLong(request.getParameter("noticeId"));
        }
        String noticeAuthor = request.getParameter("noticeAuthor");
        String noticeTitle = request.getParameter("noticeTitle");
        List<ViewNotice> viewNoticeList = viewNoticeService.getViewNoticeList(noticeId, noticeAuthor, noticeTitle);
        PageInfo pageInfo = new PageInfo(viewNoticeList);
        return new TableListVO<>(pageInfo.getTotal(), viewNoticeList);
    }

    @GetMapping("/viewNoticeAdd")
    public String viewNoticeAdd(){
        return "viewNotice-add";
    }

    @ResponseBody
    @GetMapping("/viewNotice/checkNoticeTitle/{noticeTitle}")
    public ResultVO checkNoticeTitle(@PathVariable("noticeTitle")String noticeTitle){
        ViewNotice viewNotice = viewNoticeService.getViewNotice(noticeTitle);
        if (viewNotice != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.fail("公告标题未重复");
    }

    @ResponseBody
    @PostMapping("/viewNotice")
    public ResultVO viewNotice(ViewNotice viewNotice, HttpSession session){
        boolean flag = true;
        if (viewNotice.getNoticeStatus() == null){
            flag = false;
            viewNotice.setNoticeStatus(ViewNoticeEnum.SAVE.getNoticeStatus());
        }
        String loginUser = session.getAttribute("loginUser").toString();
        viewNotice.setNoticeAuthor(loginUser);
        viewNotice.setNoticeTime(new Date());
        try{
            viewNoticeService.saveViewNotice(viewNotice);
            if (flag)
                return ResultVOUtil.success("发布成功");
            else
                return ResultVOUtil.success("保存成功");
        }catch (Exception e){
            if (flag)
                return ResultVOUtil.fail("发布失败");
            else
                return ResultVOUtil.fail("保存失败");
        }
    }

    @ResponseBody
    @PutMapping("/viewNotice/{noticeId}")
    public ResultVO viewNotice(@PathVariable("noticeId")Long noticeId, ViewNotice viewNotice, HttpSession session){
        boolean flag = true;
        if (viewNotice.getNoticeStatus() == null){
            flag = false;
            viewNotice.setNoticeStatus(ViewNoticeEnum.SAVE.getNoticeStatus());
        }
        viewNotice.setNoticeId(noticeId);
        String loginUser = session.getAttribute("loginUser").toString();
        viewNotice.setNoticeAuthor(loginUser);
        viewNotice.setNoticeTime(new Date());
        try{
            viewNoticeService.editViewNotice(viewNotice);
            if (flag)
                return ResultVOUtil.success("发布成功");
            else
                return ResultVOUtil.success("保存成功");
        }catch (Exception e){
            if (flag)
                return ResultVOUtil.fail("发布失败");
            else
                return ResultVOUtil.fail("保存失败");
        }
    }

    @ResponseBody
    @RequestMapping("/viewNotice/image")
    public KindEditor image(@RequestParam("imgFile")MultipartFile file){
        String fileName = file.getOriginalFilename();
        String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/image/viewNotice";
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
            kindEditor.setUrl(fileRootPath + "/image/viewNotice/"+fileName);
        }catch (Exception e){
            kindEditor.setError(1);
        }
        return kindEditor;
    }

    @ResponseBody
    @DeleteMapping("/viewNotice/{noticeId}")
    public ResultVO viewNoticeDel(@PathVariable("noticeId") Long noticeId){
        try{
            viewNoticeService.delViewNotice(noticeId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/viewNotice/{noticeId}")
    public String viewNotice(@PathVariable("noticeId")Long noticeId, Model model){
        ViewNotice viewNotice = viewNoticeService.getViewNotice(noticeId);
        model.addAttribute("viewNotice", viewNotice);
        return "viewNotice-edit";
    }

    @ResponseBody
    @DeleteMapping("/viewNoticeDelBatch/{id_str}")
    public ResultVO newsDelBatch(@PathVariable("id_str") String id_str){
        try{
            viewNoticeService.delBatchViewNotice(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

}
