package guet.hj.travel.service;

import guet.hj.travel.VO.HotelVO;
import guet.hj.travel.entity.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface HotelService {
    List<Hotel> getHotelList(Integer typeId);

    Map<String,Object> getHotelList(Long hotelId, Integer hotelTypeId, String hotelRelease, String hotelName);

    void saveHotel(Hotel hotel);

    void editHotel(Hotel hotel);

    Hotel getHotel(Long hotelId);

    void delHotel(Long hotelId);

    void delBatchHotel(String id_str);

    Hotel getHotel(String hotelName);

    List<HotelVO> getHotelVOList();
}
