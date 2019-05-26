package guet.hj.travel.service.impl;

import guet.hj.travel.dao.CultureActivityMapper;
import guet.hj.travel.entity.CultureActivity;
import guet.hj.travel.entity.CultureActivityExample;
import guet.hj.travel.service.CultureActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CultureActivityServiceImpl implements CultureActivityService {
    @Autowired
    private CultureActivityMapper cultureActivityMapper;

    @Override
    public List<CultureActivity> getCultureActivityList(Long activityId, String activityAuthor, String activityTitle, String activityLabel) {
        CultureActivityExample example = new CultureActivityExample();
        example.setOrderByClause("activity_time desc");
        CultureActivityExample.Criteria criteria = example.createCriteria();
        if (activityId != null){
            criteria.andActivityIdEqualTo(activityId);
        }
        if (activityAuthor != null && !activityAuthor.trim().equals("")){
            criteria.andActivityAuthorEqualTo(activityAuthor);
        }
        if (activityTitle != null && !activityTitle.trim().equals("")){
            criteria.andActivityTitleLike("%"+activityTitle+"%");
        }
        if (activityLabel != null && !activityTitle.trim().equals("")){
            criteria.andActivityLabelLike("%"+activityLabel+"%");
        }
        return cultureActivityMapper.selectByExample(example);
    }

    @Override
    public List<CultureActivity> getCultureActivityList() {
        CultureActivityExample example = new CultureActivityExample();
        example.setOrderByClause("activity_time desc");
        CultureActivityExample.Criteria criteria = example.createCriteria();
        criteria.andActivityStatusEqualTo(1);
        return cultureActivityMapper.selectByExample(example);
    }

    @Override
    public List<CultureActivity> getCultureActivityList(Long activityId) {
        CultureActivity cultureActivity = cultureActivityMapper.selectByPrimaryKey(activityId);
        CultureActivityExample example = new CultureActivityExample();
        CultureActivityExample.Criteria criteria = example.createCriteria();
        criteria.andActivityTimeLessThanOrEqualTo(cultureActivity.getActivityTime());
        List<CultureActivity> cultureActivityList = cultureActivityMapper.selectByExample(example);
        ArrayList<CultureActivity> cultureActivities = new ArrayList<>();
        if (cultureActivityList.size() == 0)
            return null;
        int count = 0;
        for(int i =0 ; i < 4; i ++)
            if (cultureActivityList.size() > i && !cultureActivityList.get(i).getActivityId().equals(activityId)){
                count ++;
                cultureActivities.add(cultureActivityList.get(i));
                if (count == 3)
                    break;
            }
        return cultureActivities;
    }

    @Transactional
    @Override
    public void saveCultureActivity(CultureActivity cultureActivity) {
        cultureActivityMapper.insertSelective(cultureActivity);
    }

    @Transactional
    @Override
    public void editCultureActivity(CultureActivity cultureActivity) {
        cultureActivityMapper.updateByPrimaryKeySelective(cultureActivity);
    }

    @Override
    public CultureActivity getCultureActivity(Long activityId) {
        return cultureActivityMapper.selectByPrimaryKey(activityId);
    }


    @Transactional
    @Override
    public void delCultureActivity(Long activityId) {
        cultureActivityMapper.deleteByPrimaryKey(activityId);
    }

    @Transactional
    @Override
    public void delBatchCultureActivity(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        CultureActivityExample example = new CultureActivityExample();
        CultureActivityExample.Criteria criteria = example.createCriteria();
        criteria.andActivityIdIn(idList);
        cultureActivityMapper.deleteByExample(example);
    }
}
