package guet.hj.travel.controller;

import guet.hj.travel.VO.HotelVO;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.Hotel;
import guet.hj.travel.entity.HotelType;
import guet.hj.travel.service.HotelService;
import guet.hj.travel.service.HotelTypeService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelTypeService hotelTypeService;

    @ResponseBody
    @GetMapping("/list")
    public ResultVO hotelList(){
        List<HotelVO> hotelList = hotelService.getHotelVOList();
        return ResultVOUtil.success(hotelList);
    }

    @ResponseBody
    @GetMapping("/{hotelId}")
    public ResultVO hotel(@PathVariable("hotelId")Long hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        HotelType hotelType = hotelTypeService.getHotelType(hotel.getHotelTypeId());
        Map<String, Object> map = new HashMap<>();
        map.put("hotel", hotel);
        map.put("hotelType", hotelType);
        return ResultVOUtil.success(map);
    }

    @ResponseBody
    @GetMapping("/others/{typeId}")
    public ResultVO hotelOthers(@PathVariable("typeId")Integer typeId){
        List<Hotel> hotelList = hotelService.getHotelList(typeId);
        return ResultVOUtil.success(hotelList);
    }
}
