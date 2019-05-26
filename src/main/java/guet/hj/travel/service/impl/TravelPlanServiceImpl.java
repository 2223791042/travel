package guet.hj.travel.service.impl;

import guet.hj.travel.dao.TravelPlanMapper;
import guet.hj.travel.entity.TravelPlan;
import guet.hj.travel.entity.TravelPlanExample;
import guet.hj.travel.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelPlanServiceImpl implements TravelPlanService {
    @Autowired
    private TravelPlanMapper travelPlanMapper;

    @Override
    public List<TravelPlan> getTravelPlanList(Long planId, String planAuthor, String planTitle) {
        TravelPlanExample example = new TravelPlanExample();
        TravelPlanExample.Criteria criteria = example.createCriteria();
        if (planId != null){
            criteria.andPlanIdEqualTo(planId);
        }
        if (planAuthor != null && !planAuthor.trim().equals("")){
            criteria.andPlanAuthorEqualTo(planAuthor);
        }
        if (planTitle != null && !planTitle.trim().equals("")){
            criteria.andPlanTitleLike("%"+planTitle+"%");
        }
        return travelPlanMapper.selectByExample(example);
    }

    @Override
    public List<TravelPlan> getTravelPlanList(Integer planSchedule, Integer planPeople, String planTitle) {
        TravelPlanExample example = new TravelPlanExample();
        example.setOrderByClause("plan_time desc");
        TravelPlanExample.Criteria criteria = example.createCriteria();
        if (planSchedule != null){
            criteria.andPlanScheduleEqualTo(planSchedule);
        }
        if (planPeople != null){
            criteria.andPlanPeopleEqualTo(planPeople);
        }
        if (planTitle != null && !planTitle.trim().equals("")){
            criteria.andPlanTitleLike("%"+planTitle+"%");
        }
        criteria.andPlanStatusEqualTo(1);
        return travelPlanMapper.selectByExample(example);
    }

    @Override
    public TravelPlan getTravelPlan(Long planId) {
        return travelPlanMapper.selectByPrimaryKey(planId);
    }

    @Transactional
    @Override
    public void editTravelPlan(TravelPlan travelPlan) {
        travelPlanMapper.updateByPrimaryKeySelective(travelPlan);
    }

    @Transactional
    @Override
    public void saveTravelPlan(TravelPlan travelPlan) {
        travelPlanMapper.insertSelective(travelPlan);
    }

    @Transactional
    @Override
    public void delTravelPlan(Long planId) {
        travelPlanMapper.deleteByPrimaryKey(planId);
    }

    @Transactional
    @Override
    public void delBatchTravelPlan(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        TravelPlanExample example = new TravelPlanExample();
        TravelPlanExample.Criteria criteria = example.createCriteria();
        criteria.andPlanIdIn(idList);
        travelPlanMapper.deleteByExample(example);
    }
}
