package guet.hj.travel.dao;

import guet.hj.travel.entity.ViewNotice;
import guet.hj.travel.entity.ViewNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewNoticeMapper {
    int countByExample(ViewNoticeExample example);

    int deleteByExample(ViewNoticeExample example);

    int deleteByPrimaryKey(Long noticeId);

    int insert(ViewNotice record);

    int insertSelective(ViewNotice record);

    List<ViewNotice> selectByExample(ViewNoticeExample example);

    ViewNotice selectByPrimaryKey(Long noticeId);

    int updateByExampleSelective(@Param("record") ViewNotice record, @Param("example") ViewNoticeExample example);

    int updateByExample(@Param("record") ViewNotice record, @Param("example") ViewNoticeExample example);

    int updateByPrimaryKeySelective(ViewNotice record);

    int updateByPrimaryKey(ViewNotice record);
}