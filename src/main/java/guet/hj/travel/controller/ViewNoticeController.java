package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.ViewNotice;
import guet.hj.travel.enums.ViewNoticeEnum;
import guet.hj.travel.service.ViewNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/viewNotice")
public class ViewNoticeController {
    @Autowired
    private ViewNoticeService viewNoticeService;

    @ResponseBody
    @GetMapping("/list")
    public TableListVO<ViewNotice> list(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "limit",defaultValue = "3") int limit) {
        PageHelper.startPage(page, limit);
        List<ViewNotice> viewNoticeList = viewNoticeService.getViewNoticeList(ViewNoticeEnum.RELEASE.getNoticeStatus());
        PageInfo<ViewNotice> pageInfo = new PageInfo<>(viewNoticeList);
        return new TableListVO<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
