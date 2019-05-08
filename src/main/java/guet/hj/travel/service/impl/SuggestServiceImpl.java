package guet.hj.travel.service.impl;

import guet.hj.travel.dao.SuggestMapper;
import guet.hj.travel.entity.Suggest;
import guet.hj.travel.entity.SuggestExample;
import guet.hj.travel.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    private SuggestMapper suggestMapper;

    @Transactional
    @Override
    public void saveSuggest(Suggest suggest) {
        suggest.setSuggestTime(new Date());
        suggestMapper.insertSelective(suggest);
    }

    @Override
    public List<Suggest> getSuggestList(Date startTime, Date endTime, String title) {
        SuggestExample example = new SuggestExample();
        SuggestExample.Criteria criteria = example.createCriteria();
        if (startTime != null){
            criteria.andSuggestTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){
            criteria.andSuggestTimeLessThanOrEqualTo(endTime);
        }
        if (title != null && !title.trim().equals("")){
            criteria.andTitleLike("%"+title+"%");
        }
        return suggestMapper.selectByExample(example);
    }

    @Override
    public Suggest getSuggest(Long suggestId) {
        return suggestMapper.selectByPrimaryKey(suggestId);
    }

    @Transactional
    @Override
    public void delSuggest(Long suggestId) {
        suggestMapper.deleteByPrimaryKey(suggestId);
    }

    @Transactional
    @Override
    public void delBatchSuggest(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        SuggestExample example = new SuggestExample();
        SuggestExample.Criteria criteria = example.createCriteria();
        criteria.andSuggestIdIn(idList);
        suggestMapper.deleteByExample(example);
    }
}
