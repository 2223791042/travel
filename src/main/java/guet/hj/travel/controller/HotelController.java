package guet.hj.travel.controller;

import guet.hj.travel.VO.HotelVO;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.Hotel;
import guet.hj.travel.service.HotelService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

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
        return ResultVOUtil.success(hotel);
    }
}
