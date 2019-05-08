package guet.hj.travel.service;

import guet.hj.travel.dto.NewsDTO;
import guet.hj.travel.entity.News;

import java.util.List;
import java.util.Map;

public interface NewsService {
    List<News> getNewsList(Integer labelId);

    Map<String,Object> getNewsDTOList(Long newsId, String newsAuthor, String newsTitle, Integer newsLabelId);

    NewsDTO getNewsDTO(Long newsId);

    News getNews(String newsTitle);

    void saveNews(News news);

    void editNews(News news, String type);

    void delNews(Long newsId);

    void delBatchNews(String id_str);

    Map<String,Object> getNewsDTOList(String newsStatus);

    NewsDTO getNewsDTO(Long newsId, String newsStatus);
}
