package guet.hj.travel.service.impl;

import guet.hj.travel.dao.NewsLabelMapper;
import guet.hj.travel.entity.NewsLabel;
import guet.hj.travel.entity.NewsLabelExample;
import guet.hj.travel.service.NewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsLabelServiceImpl implements NewsLabelService {
    @Autowired
    private NewsLabelMapper newsLabelMapper;

    @Override
    public List<NewsLabel> getNewsLabelList() {
        return newsLabelMapper.selectByExample(null);
    }

    @Override
    public NewsLabel getNewsLabel(Integer labelId) {
        return newsLabelMapper.selectByPrimaryKey(labelId);
    }

    @Transactional
    @Override
    public void editNewsLabel(NewsLabel newsLabel) {
        newsLabelMapper.updateByPrimaryKeySelective(newsLabel);
    }

    @Transactional
    @Override
    public void delNewsLabel(Integer labelId) {
        newsLabelMapper.deleteByPrimaryKey(labelId);
    }

    @Override
    public NewsLabel getNewsLabel(String labelName) {
        NewsLabelExample example = new NewsLabelExample();
        NewsLabelExample.Criteria criteria = example.createCriteria();
        criteria.andLabelNameEqualTo(labelName);
        List<NewsLabel> newsLabelList = newsLabelMapper.selectByExample(example);
        if (newsLabelList.size() != 0){
            return newsLabelList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveNewsLabel(NewsLabel newsLabel) {
        newsLabelMapper.insertSelective(newsLabel);
    }
}
