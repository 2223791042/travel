package guet.hj.travel.service;

import guet.hj.travel.entity.Suggest;

import java.util.Date;
import java.util.List;

public interface SuggestService {
    void saveSuggest(Suggest suggest);

    List<Suggest> getSuggestList(Date startTime, Date endTime, String title);

    Suggest getSuggest(Long suggestId);

    void delSuggest(Long suggestId);

    void delBatchSuggest(String id_str);
}
