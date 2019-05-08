package guet.hj.travel.service.impl;

import guet.hj.travel.dao.RoomMapper;
import guet.hj.travel.entity.Room;
import guet.hj.travel.entity.RoomExample;
import guet.hj.travel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> getRoomList(Long roomId, String roomRelease, BigDecimal roomPrice, String roomHotelName) {
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        if (roomId != null){
            criteria.andRoomIdEqualTo(roomId);
        }
        if (roomRelease != null && !roomRelease.trim().equals("")){
            criteria.andRoomReleaseLike("%"+roomRelease+"%");
        }
        if (roomPrice != null){
            criteria.andRoomPriceLessThanOrEqualTo(roomPrice);
        }
        if (roomHotelName != null && !roomHotelName.trim().equals("")){
            criteria.andRoomHotelNameLike("%"+roomHotelName+"%");
        }
        return roomMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public void saveRoom(Room room) {
        roomMapper.insertSelective(room);
    }

    @Override
    public Room getRoom(Long roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Transactional
    @Override
    public void editRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    @Transactional
    @Override
    public void delRoom(Long roomId) {
        roomMapper.deleteByPrimaryKey(roomId);
    }

    @Transactional
    @Override
    public void delBatchRoom(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for(String id : ids){
            idList.add(Long.parseLong(id));
        }
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdIn(idList);
        roomMapper.deleteByExample(example);
    }
}
