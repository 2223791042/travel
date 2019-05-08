package guet.hj.travel.service.impl;

import com.github.pagehelper.PageInfo;
import guet.hj.travel.dao.NewsLabelMapper;
import guet.hj.travel.dao.NewsMapper;
import guet.hj.travel.dto.NewsDTO;
import guet.hj.travel.entity.News;
import guet.hj.travel.entity.NewsExample;
import guet.hj.travel.entity.NewsLabel;
import guet.hj.travel.enums.NewsEnum;
import guet.hj.travel.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsLabelMapper newsLabelMapper;

    @Override
    public Map<String, Object> getNewsDTOList(String newsStatus) {
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        newsExample.setOrderByClause("news_time desc");
        criteria.andNewsStatusEqualTo(newsStatus);
        List<News> newsList = newsMapper.selectByExample(newsExample);
        PageInfo pageInfo = new PageInfo<>(newsList);
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for(News news : newsList){
            NewsDTO newsDTO = new NewsDTO();
            BeanUtils.copyProperties(news, newsDTO);
            NewsLabel newsLabel = newsLabelMapper.selectByPrimaryKey(news.getNewsLabelId());
            newsDTO.setNewsLabel(newsLabel);
            newsDTOList.add(newsDTO);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("newsDTOList", newsDTOList);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Override
    public NewsDTO getNewsDTO(Long newsId, String newsStatus) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdEqualTo(newsId);
        criteria.andNewsStatusEqualTo(newsStatus);
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList.size() != 0){
            News news = newsList.get(0);
            NewsLabel newsLabel = newsLabelMapper.selectByPrimaryKey(news.getNewsLabelId());
            NewsDTO newsDTO = new NewsDTO();
            BeanUtils.copyProperties(news, newsDTO);
            newsDTO.setNewsLabel(newsLabel);
            return newsDTO;
        }
        return null;
    }

    @Override
    public List<News> getNewsList(Integer labelId) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsLabelIdEqualTo(labelId);
        return newsMapper.selectByExample(example);
    }

    @Override
    public Map<String, Object> getNewsDTOList(Long newsId, String newsAuthor, String newsTitle, Integer newsLabelId) {
        NewsExample newsExample = new NewsExample();
        NewsExample.Criteria criteria = newsExample.createCriteria();
        if (newsId != null){
            criteria.andNewsIdEqualTo(newsId);
        }
        if(newsAuthor != null && !newsAuthor.trim().equals("")){
            criteria.andNewsAuthorLike("%"+newsAuthor+"%");
        }
        if(newsTitle != null && !newsTitle.trim().equals("")){
            criteria.andNewsTitleLike("%"+newsTitle+"%");
        }
        if(newsLabelId != null){
            criteria.andNewsLabelIdEqualTo(newsLabelId);
        }
        newsExample.setOrderByClause("news_time desc");
        List<News> newsList = newsMapper.selectByExample(newsExample);
        PageInfo pageInfo = new PageInfo<>(newsList);
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for(News news : newsList){
            NewsDTO newsDTO = new NewsDTO();
            BeanUtils.copyProperties(news, newsDTO);
            NewsLabel newsLabel = newsLabelMapper.selectByPrimaryKey(news.getNewsLabelId());
            newsDTO.setNewsLabel(newsLabel);
            newsDTOList.add(newsDTO);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("newsDTOList", newsDTOList);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Override
    public NewsDTO getNewsDTO(Long newsId) {
        News news = newsMapper.selectByPrimaryKey(newsId);
        NewsLabel newsLabel = newsLabelMapper.selectByPrimaryKey(news.getNewsLabelId());
        NewsDTO newsDTO = new NewsDTO();
        BeanUtils.copyProperties(news, newsDTO);
        newsDTO.setNewsLabel(newsLabel);
        return newsDTO;
    }

    @Override
    public News getNews(String newsTitle) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsTitleEqualTo(newsTitle);
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList.size() != 0){
            return newsList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveNews(News news) {
        newsMapper.insertSelective(news);
    }

    @Transactional
    @Override
    public void editNews(News news, String type) {
        if(type.equals("save")){
            news.setNewsStatus(NewsEnum.SAVE.getNewsStatus());
        }
        if (type.equals("release")){
            news.setNewsStatus(NewsEnum.RELEASE.getNewsStatus());
        }
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Transactional
    @Override
    public void delNews(Long newsId) {
        newsMapper.deleteByPrimaryKey(newsId);
    }

    @Transactional
    @Override
    public void delBatchNews(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andNewsIdIn(idList);
        newsMapper.deleteByExample(example);
    }
}
