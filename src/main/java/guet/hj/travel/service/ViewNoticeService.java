package guet.hj.travel.service;

import guet.hj.travel.entity.ViewNotice;

import java.util.List;

public interface ViewNoticeService {
    List<ViewNotice> getViewNoticeList(Long noticeId, String noticeAuthor, String noticeTitle);

    ViewNotice getViewNotice(String noticeTitle);

    void saveViewNotice(ViewNotice viewNotice);

    void delViewNotice(Long noticeId);

    void delBatchViewNotice(String id_str);

    ViewNotice getViewNotice(Long noticeId);

    void editViewNotice(ViewNotice viewNotice);

    List<ViewNotice> getViewNoticeList(String noticeStatus);
}
