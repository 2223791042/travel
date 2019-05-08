package guet.hj.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.VO.TableListVO;
import guet.hj.travel.dao.RoomMapper;
import guet.hj.travel.entity.Room;
import guet.hj.travel.service.RoomService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminRoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/room")
    public String roomList(){
        return "room-list";
    }

    @ResponseBody
    @GetMapping("/roomList")
    public TableListVO<Room> roomList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long roomId = null;
        if (request.getParameter("roomId") != null){
            if (!request.getParameter("roomId").trim().equals("")){
                roomId = Long.parseLong(request.getParameter("roomId"));
            }
        }
        String roomRelease = request.getParameter("roomRelease");
        BigDecimal roomPrice = null;
        if (request.getParameter("roomPrice") != null){
            if (!request.getParameter("roomPrice").trim().equals("")){
                roomPrice = new BigDecimal(request.getParameter("roomPrice"));
            }
        }
        String roomHotelName = request.getParameter("roomHotelName");
        List<Room> roomList = roomService.getRoomList(roomId, roomRelease, roomPrice, roomHotelName);
        PageInfo<Room> pageInfo = new PageInfo<>(roomList);
        return new TableListVO<>(pageInfo.getTotal(), roomList);
    }

    @GetMapping("/roomAdd")
    public String roomAdd(){
        return "room-add";
    }

    @ResponseBody
    @PostMapping("/room")
    public ResultVO roomAdd(Room room, HttpSession session){
        try{
            if (room.getRoomStatus() == null){
                room.setRoomStatus("0");
            }
            room.setRoomReleaseTime(new Date());
            room.setRoomRelease(session.getAttribute("loginUser").toString());
            roomService.saveRoom(room);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @GetMapping("/room/{roomId}")
    public String roomEdit(@PathVariable("roomId") Long roomId, Model model){
        Room room = roomService.getRoom(roomId);
        model.addAttribute("room", room);
        return "room-edit";
    }

    @ResponseBody
    @PutMapping("/room/{roomId}")
    public ResultVO roomEdit(@PathVariable("roomId")Long roomId, Room room, HttpSession session){
        try {
            if (room.getRoomStatus() == null){
                room.setRoomStatus("0");
            }
            room.setRoomId(roomId);
            room.setRoomReleaseTime(new Date());
            room.setRoomRelease(session.getAttribute("loginUser").toString());
            roomService.editRoom(room);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/room/{roomId}")
    public ResultVO roomDel(@PathVariable("roomId")Long roomId){
        try {
            roomService.delRoom(roomId);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }

    @ResponseBody
    @DeleteMapping("/roomDelBatch/{id_str}")
    public ResultVO roomDelBatch(@PathVariable("id_str")String id_str){
        try {
            roomService.delBatchRoom(id_str);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }
    }
}
