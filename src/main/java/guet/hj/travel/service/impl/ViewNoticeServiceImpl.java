package guet.hj.travel.service.impl;

import guet.hj.travel.dao.ViewNoticeMapper;
import guet.hj.travel.entity.ViewNotice;
import guet.hj.travel.entity.ViewNoticeExample;
import guet.hj.travel.service.ViewNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewNoticeServiceImpl implements ViewNoticeService {

    @Autowired
    private ViewNoticeMapper viewNoticeMapper;

    @Override
    public List<ViewNotice> getViewNoticeList(Long noticeId, String noticeAuthor, String noticeTitle) {
        ViewNoticeExample example = new ViewNoticeExample();
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        if (noticeId != null){
            criteria.andNoticeIdEqualTo(noticeId);
        }
        if(noticeAuthor != null && !noticeAuthor.trim().equals("")){
            criteria.andNoticeAuthorLike("%"+noticeAuthor+"%");
        }
        if(noticeTitle != null && !noticeTitle.trim().equals("")){
            criteria.andNoticeTitleLike("%"+noticeTitle+"%");
        }
        return viewNoticeMapper.selectByExample(example);
    }

    @Override
    public ViewNotice getViewNotice(String noticeTitle) {
        ViewNoticeExample example = new ViewNoticeExample();
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeTitleEqualTo(noticeTitle);
        List<ViewNotice> viewNoticeList = viewNoticeMapper.selectByExample(example);
        if (viewNoticeList.size() != 0){
            return viewNoticeList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveViewNotice(ViewNotice viewNotice) {
        viewNoticeMapper.insertSelective(viewNotice);
    }

    @Transactional
    @Override
    public void delViewNotice(Long noticeId) {
        viewNoticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Transactional
    @Override
    public void delBatchViewNotice(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        ViewNoticeExample example = new ViewNoticeExample();
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeIdIn(idList);
        viewNoticeMapper.deleteByExample(example);
    }

    @Override
    public ViewNotice getViewNotice(Long noticeId) {
        return viewNoticeMapper.selectByPrimaryKey(noticeId);
    }

    @Transactional
    @Override
    public void editViewNotice(ViewNotice viewNotice) {
        viewNoticeMapper.updateByPrimaryKeySelective(viewNotice);
    }

    @Override
    public List<ViewNotice> getViewNoticeList(String noticeStatus) {
        ViewNoticeExample example = new ViewNoticeExample();
        example.setOrderByClause("notice_time desc");
        ViewNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeStatusEqualTo(noticeStatus);
        return viewNoticeMapper.selectByExample(example);
    }
}
