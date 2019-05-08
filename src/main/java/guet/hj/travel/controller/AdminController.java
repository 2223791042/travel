package guet.hj.travel.controller;

import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.User;
import guet.hj.travel.enums.ResultEnum;
import guet.hj.travel.service.UserService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/login")
    public ResultVO login(User user, String verifyCode, HttpSession session){
        String saveVerifyCode = (String) session.getAttribute("verifyCode");
        if (saveVerifyCode.toUpperCase().equals(verifyCode.toUpperCase())){
            User saveUser = userService.getUser(user.getUsername());
            if(saveUser == null){
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"用户名不存在");
            }else if(saveUser.getPassword().equals(user.getPassword())){
                session.setAttribute("loginUser", user.getUsername());
                return ResultVOUtil.success();
            }else{
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"密码错误");
            }
        }
        return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"验证码错误");
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 主页页面
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/nav")
    public String nav(){
        return "nav";
    }

    /**
     * 登录退出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        session.invalidate();
        return "login";
    }
}
