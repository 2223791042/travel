package guet.hj.travel.controller;

import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.Hotel;
import guet.hj.travel.entity.HotelType;
import guet.hj.travel.service.HotelService;
import guet.hj.travel.service.HotelTypeService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHotelTypeController {
    @Autowired
    private HotelTypeService hotelTypeService;

    @Autowired
    private HotelService hotelService;

    @ResponseBody
    @GetMapping("/hotelTypeList")
    public ResultVO hotelTypeList(){
        List<HotelType> hotelTypeList = hotelTypeService.getHotelTypeList();
        return ResultVOUtil.success(hotelTypeList);
    }

    @GetMapping("/hotelType")
    public String hotelType(){
        return "hotelType-list";
    }

    @GetMapping("/hotelTypeAdd")
    public String hotelTypeAdd(){
        return "hotelType-add";
    }

    @ResponseBody
    @DeleteMapping("/hotelType/{typeId}")
    public ResultVO hotelTypeDel(@PathVariable("typeId")Integer typeId){
        List<Hotel> hotelList = hotelService.getHotelList(typeId);
        if(hotelList.size() == 0){
            try{
                hotelTypeService.delHotelType(typeId);
                return ResultVOUtil.success();
            }catch (Exception e){
                return ResultVOUtil.fail("删除失败");
            }
        }else {
            return ResultVOUtil.fail("由于该类型已绑定新闻无法删除！");
        }
    }

    @ResponseBody
    @GetMapping("/hotelType/checkTypeName/{typeName}")
    public ResultVO checkTypeName(@PathVariable("typeName")String typeName){
        HotelType hotelType = hotelTypeService.getHotelType(typeName);
        if (hotelType != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.fail("类型名重复");
    }

    @ResponseBody
    @PostMapping("/hotelType")
    public ResultVO hotelTypeAdd(HotelType hotelType, HttpSession session){
        try{
            String loginUser = (String) session.getAttribute("loginUser");
            hotelType.setTypeCreator(loginUser);
            hotelType.setTypeCreateTime(new Date());
            hotelTypeService.saveHotelType(hotelType);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

}
