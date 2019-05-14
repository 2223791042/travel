package guet.hj.travel.service;

import guet.hj.travel.entity.CultureActivity;

import java.util.List;

public interface CultureActivityService {
    List<CultureActivity> getCultureActivityList(Long activityId, String activityAuthor, String activityTitle, String activityLabel);

    void saveCultureActivity(CultureActivity cultureActivity);

    void editCultureActivity(CultureActivity cultureActivity);

    CultureActivity getCultureActivity(Long activityId);

    void delCultureActivity(Long activityId);

    void delBatchCultureActivity(String id_str);

    List<CultureActivity> getCultureActivityList();

    List<CultureActivity> getCultureActivityList(Long activityId);
}
