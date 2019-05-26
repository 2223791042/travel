package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.entity.TravelPlan;
import guet.hj.travel.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/travelPlan")
public class TravelPlanController {
    @Autowired
    private TravelPlanService travelPlanService;

    @ResponseBody
    @GetMapping("/list")
    public TableListVO<TravelPlan> travelPlanList(int page, int limit,HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Integer planSchedule = null;
        Integer planPeople = null;
        if (request.getParameter("planSchedule")!=null && !request.getParameter("planSchedule").trim().equals("")){
            planSchedule = Integer.parseInt(request.getParameter("planSchedule"));
        }
        if (request.getParameter("planPeople")!=null && !request.getParameter("planPeople").trim().equals("")){
            planPeople = Integer.parseInt(request.getParameter("planPeople"));
        }
        String planTitle = request.getParameter("planTitle");
        List<TravelPlan> travelPlanList = travelPlanService.getTravelPlanList(planSchedule, planPeople, planTitle);
        PageInfo<TravelPlan> pageInfo = new PageInfo<>(travelPlanList);
        return new TableListVO<>(pageInfo.getTotal(), travelPlanList);
    }
}
