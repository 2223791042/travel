package guet.hj.travel.dao;

import guet.hj.travel.entity.HotelType;
import guet.hj.travel.entity.HotelTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelTypeMapper {
    int countByExample(HotelTypeExample example);

    int deleteByExample(HotelTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(HotelType record);

    int insertSelective(HotelType record);

    List<HotelType> selectByExample(HotelTypeExample example);

    HotelType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") HotelType record, @Param("example") HotelTypeExample example);

    int updateByExample(@Param("record") HotelType record, @Param("example") HotelTypeExample example);

    int updateByPrimaryKeySelective(HotelType record);

    int updateByPrimaryKey(HotelType record);
}