package guet.hj.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import guet.hj.travel.entity.HotelType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class HotelDTO {
    private Long hotelId;

    private String hotelName;

    private String hotelSummary;

    private String hotelIcon;

    private String hotelImage;

    private Integer hotelOrder;

    private String hotelStatus;

    private String hotelRelease;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date hotelReleaseTime;

    private HotelType hotelType;
}
