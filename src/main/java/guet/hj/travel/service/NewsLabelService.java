package guet.hj.travel.service;

import guet.hj.travel.entity.NewsLabel;

import java.util.List;

public interface NewsLabelService {
    List<NewsLabel> getNewsLabelList();

    NewsLabel getNewsLabel(Integer labelId);

    void editNewsLabel(NewsLabel newsLabel);

    void delNewsLabel(Integer labelId);

    NewsLabel getNewsLabel(String labelName);

    void saveNewsLabel(NewsLabel newsLabel);
}
