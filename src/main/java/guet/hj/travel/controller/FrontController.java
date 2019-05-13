package guet.hj.travel.controller;

import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.FrontUser;
import guet.hj.travel.enums.ResultEnum;
import guet.hj.travel.service.FrontUserService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/front")
public class FrontController {

    @Autowired
    private FrontUserService frontUserService;

    @ResponseBody
    @PostMapping(value = "/login")
    public ResultVO login(FrontUser user, String verifyCode, HttpSession session){
        String saveVerifyCode = (String) session.getAttribute("verifyCode");
        if (saveVerifyCode.toUpperCase().equals(verifyCode.toUpperCase())){
            FrontUser saveUser = frontUserService.getFrontUser(user.getUserPhone());
            if(saveUser == null){
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"用户名不存在");
            }else if(saveUser.getUserPassword().equals(user.getUserPassword())){
                session.setAttribute("loginUser", saveUser);
                return ResultVOUtil.success();
            }else{
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"密码错误");
            }
        }
        return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"验证码错误");
    }

    @ResponseBody
    @PostMapping("/register")
    public ResultVO register(FrontUser frontUser, String verifyCode, HttpSession session){
        String saveVerifyCode = (String) session.getAttribute("verifyCode");
        if (saveVerifyCode.toUpperCase().equals(verifyCode.toUpperCase())){
            FrontUser saveUser = frontUserService.getFrontUser(frontUser.getUserPhone());
            if (saveUser != null){
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"该手机号已经被注册");
            }
            try{
                frontUser.setUserRegisterTime(new Date());
                frontUserService.saveFrontUser(frontUser);
            }catch (Exception e){
                return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"注册失败");
            }
        }
        return ResultVOUtil.error(ResultEnum.FAIL.getCode(),"验证码错误");
    }

}
