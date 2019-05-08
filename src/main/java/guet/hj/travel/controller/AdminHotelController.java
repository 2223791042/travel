package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.dto.HotelDTO;
import guet.hj.travel.entity.Hotel;
import guet.hj.travel.entity.HotelType;
import guet.hj.travel.entity.KindEditor;
import guet.hj.travel.service.HotelService;
import guet.hj.travel.service.HotelTypeService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminHotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelTypeService hotelTypeService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @GetMapping("/hotel")
    public String hotelList(){
        return "hotel-list";
    }

    @ResponseBody
    @GetMapping("/hotelList")
    public TableListVO<HotelDTO> hotelList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long hotelId = null;
        if (request.getParameter("hotelId") != null){
            if (!request.getParameter("hotelId").trim().equals("")){
                hotelId = Long.parseLong(request.getParameter("hotelId"));
            }
        }
        Integer hotelTypeId = null;
        if (request.getParameter("hotelTypeId") != null){
            if (!request.getParameter("hotelTypeId").trim().equals("")){
                hotelTypeId = Integer.parseInt(request.getParameter("hotelTypeId"));
            }
        }
        String hotelRelease = request.getParameter("hotelRelease");
        String hotelName = request.getParameter("hotelName");
        Map<String, Object> map = hotelService.getHotelList(hotelId, hotelTypeId, hotelRelease, hotelName);
        PageInfo pageInfo = (PageInfo) map.get("pageInfo");
        List<HotelDTO> hotelDTOList = (List<HotelDTO>)map.get("hotelDTOList");
        return new TableListVO<>(pageInfo.getTotal(), hotelDTOList);
    }

    @ResponseBody
    @PostMapping("/hotel")
    public ResultVO hotelAdd(@RequestParam("icon")MultipartFile icon, @RequestParam("image") MultipartFile image, Hotel hotel, HttpSession session){
        try {
            if (!icon.isEmpty()) {
                hotel.setHotelIcon(saveImg(icon));
            }
            if (!image.isEmpty()){
                hotel.setHotelImage(saveImg(image));
            }
            if (hotel.getHotelStatus() == null){
                hotel.setHotelStatus("0");
            }
            hotel.setHotelRelease(session.getAttribute("loginUser").toString());
            hotel.setHotelReleaseTime(new Date());
            hotelService.saveHotel(hotel);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/hotel/{hotelId}")
    public String hotelEdit(@PathVariable("hotelId")Long hotelId, Model model){
        Hotel hotel = hotelService.getHotel(hotelId);
        List<HotelType> hotelTypeList = hotelTypeService.getHotelTypeList();
        model.addAttribute("hotel", hotel);
        model.addAttribute("hotelTypeList", hotelTypeList);
        return "hotel-edit";
    }

    @GetMapping("/hotelAdd")
    public String hotelAdd(Model model){
        List<HotelType> hotelTypeList = hotelTypeService.getHotelTypeList();
        model.addAttribute("hotelTypeList", hotelTypeList);
        return "hotel-add";
    }

    @ResponseBody
    @PutMapping("/hotel/{hotelId}")
    public ResultVO hotelEdit(@PathVariable("hotelId")Long hotelId, @RequestParam("icon")MultipartFile icon,@RequestParam("image")MultipartFile image, Hotel hotel, HttpSession session){
        hotel.setHotelId(hotelId);
        try {
            if (!icon.isEmpty()) {
                hotel.setHotelIcon(saveImg(icon));
            }
            if (!image.isEmpty()){
                hotel.setHotelImage(saveImg(image));
            }
            if (hotel.getHotelStatus() == null){
                hotel.setHotelStatus("0");
            }
            hotel.setHotelRelease(session.getAttribute("loginUser").toString());
            hotel.setHotelReleaseTime(new Date());
            hotelService.editHotel(hotel);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/hotel/{hotelId}")
    public ResultVO hotelDel(@PathVariable("hotelId")Long hotelId){
        try{
            hotelService.delHotel(hotelId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/hotelDelBatch/{id_str}")
    public ResultVO hotelDelBatch(@PathVariable("id_str") String id_str){
        try{
            hotelService.delBatchHotel(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("删除失败");
        }
    }

    @ResponseBody
    @RequestMapping("/hotel/image")
    public KindEditor image(@RequestParam("imgFile")MultipartFile file){
        KindEditor kindEditor = new KindEditor();
        try{
            kindEditor.setError(0);
            kindEditor.setUrl(saveImg(file));
        }catch (Exception e){
            kindEditor.setError(1);
        }
        return kindEditor;
    }

    private String saveImg(MultipartFile img) throws Exception{
        String fileName = img.getOriginalFilename();
        String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/image/hotel";
        folderPath = URLDecoder.decode(folderPath, "UTF-8");
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File dest = new File(folderPath + "/" + fileName);
        img.transferTo(dest);
        String imageUrl = fileRootPath + "/image/hotel/" + fileName;
        return imageUrl;
    }

    @ResponseBody
    @GetMapping("/hotelExist/{hotelName}")
    public ResultVO hotelExist(@PathVariable("hotelName") String hotelName){
        Hotel hotel = hotelService.getHotel(hotelName);
        if (hotel != null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.fail();
    }
}
