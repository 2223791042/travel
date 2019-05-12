package guet.hj.travel.VO;

import guet.hj.travel.entity.Hotel;
import lombok.Data;

import java.util.List;

@Data
public class HotelVO {
    private String hotelType;
    private List<Hotel> hotelList;
}
