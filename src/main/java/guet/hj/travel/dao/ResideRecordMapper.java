package guet.hj.travel.dao;

import guet.hj.travel.entity.ResideRecord;
import guet.hj.travel.entity.ResideRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResideRecordMapper {
    int countByExample(ResideRecordExample example);

    int deleteByExample(ResideRecordExample example);

    int deleteByPrimaryKey(Long resideId);

    int insert(ResideRecord record);

    int insertSelective(ResideRecord record);

    List<ResideRecord> selectByExample(ResideRecordExample example);

    ResideRecord selectByPrimaryKey(Long resideId);

    int updateByExampleSelective(@Param("record") ResideRecord record, @Param("example") ResideRecordExample example);

    int updateByExample(@Param("record") ResideRecord record, @Param("example") ResideRecordExample example);

    int updateByPrimaryKeySelective(ResideRecord record);

    int updateByPrimaryKey(ResideRecord record);
}