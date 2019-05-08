package guet.hj.travel.service;

import guet.hj.travel.entity.Room;

import java.math.BigDecimal;
import java.util.List;

public interface RoomService {
    List<Room> getRoomList(Long roomId, String roomRelease, BigDecimal roomPrice, String roomHotelName);

    void saveRoom(Room room);

    Room getRoom(Long roomId);

    void editRoom(Room room);

    void delRoom(Long roomId);

    void delBatchRoom(String id_str);
}
