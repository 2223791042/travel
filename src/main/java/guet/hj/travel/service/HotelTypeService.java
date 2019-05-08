package guet.hj.travel.service;

import guet.hj.travel.entity.HotelType;

import java.util.List;

public interface HotelTypeService {
    List<HotelType> getHotelTypeList();

    HotelType getHotelType(Integer typeId);

    void delHotelType(Integer typeId);

    HotelType getHotelType(String typeName);

    void saveHotelType(HotelType hotelType);
}
