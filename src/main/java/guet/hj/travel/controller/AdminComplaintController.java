package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.Complaint;
import guet.hj.travel.entity.Suggest;
import guet.hj.travel.service.ComplaintService;
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
public class AdminComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/complaint")
    public String complaint(){
        return "complaint-list";
    }

    @ResponseBody
    @GetMapping("/complaintList")
    public TableListVO<Complaint> suggestList(int page, int limit, HttpServletRequest request){
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
        List<Complaint> complaintList = complaintService.getComplaintList(startTime, endTime, title);
        PageInfo<Complaint> pageInfo = new PageInfo<>(complaintList);
        return new TableListVO<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @GetMapping("/complaint/{complaintId}")
    public String look(@PathVariable("complaintId")Long complaintId, Model model){
        Complaint complaint = complaintService.getComplaint(complaintId);
        model.addAttribute("complaint", complaint);
        return "complaint-look";
    }

    @ResponseBody
    @DeleteMapping("/complaintDelBatch/{id_str}")
    public ResultVO complaintDelBatch(@PathVariable("id_str") String id_str){
        try{
            complaintService.delBatchComplaint(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

    @ResponseBody
    @DeleteMapping("/complaint/{complaintId}")
    public ResultVO complaintDel(@PathVariable("complaintId") Long complaintId){
        try{
            complaintService.delComplaint(complaintId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

}
