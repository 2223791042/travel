package guet.hj.travel.service;

import guet.hj.travel.entity.TravelPlan;

import java.util.List;

public interface TravelPlanService {
    List<TravelPlan> getTravelPlanList(Long planId, String planAuthor, String planTitle);

    void saveTravelPlan(TravelPlan travelPlan);

    TravelPlan getTravelPlan(Long planId);

    void editTravelPlan(TravelPlan travelPlan);

    void delTravelPlan(Long planId);

    void delBatchTravelPlan(String id_str);

    List<TravelPlan> getTravelPlanList(Integer planSchedule, Integer planPeople, String planTitle);
}
