package guet.hj.travel.dao;

import guet.hj.travel.entity.Room;
import guet.hj.travel.entity.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Long roomId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Long roomId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}