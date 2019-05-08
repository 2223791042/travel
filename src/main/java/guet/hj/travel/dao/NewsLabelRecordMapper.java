package guet.hj.travel.dao;

import guet.hj.travel.entity.NewsLabelRecord;
import guet.hj.travel.entity.NewsLabelRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsLabelRecordMapper {
    int countByExample(NewsLabelRecordExample example);

    int deleteByExample(NewsLabelRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(NewsLabelRecord record);

    int insertSelective(NewsLabelRecord record);

    List<NewsLabelRecord> selectByExample(NewsLabelRecordExample example);

    NewsLabelRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") NewsLabelRecord record, @Param("example") NewsLabelRecordExample example);

    int updateByExample(@Param("record") NewsLabelRecord record, @Param("example") NewsLabelRecordExample example);

    int updateByPrimaryKeySelective(NewsLabelRecord record);

    int updateByPrimaryKey(NewsLabelRecord record);
}