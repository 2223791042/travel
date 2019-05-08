package guet.hj.travel.controller;

import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.entity.Complaint;
import guet.hj.travel.service.ComplaintService;
import guet.hj.travel.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLDecoder;

@Controller
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @Value("${fileRootPath}")
    private String fileRootPath;

    @ResponseBody
    @PostMapping("/complaint")
    public ResultVO complaint(String verifyCode, Complaint complaint, @RequestParam("carryFileS")MultipartFile carryFileS, HttpSession session){
        String saveVerifyCode = (String)session.getAttribute("verifyCode");
        if (!verifyCode.toUpperCase().equals(saveVerifyCode.toUpperCase())){
            return ResultVOUtil.fail("验证码错误!");
        }
        try{
            if(!carryFileS.isEmpty()){
                String fileName = carryFileS.getOriginalFilename();
                String folderPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/complaint/file";
                folderPath = URLDecoder.decode(folderPath, "UTF-8");
                File folder = new File(folderPath);
                if(!folder.exists()){
                    folder.mkdirs();
                }
                File dest = new File(folderPath +"/" + fileName);
                carryFileS.transferTo(dest);
                String fileUrl = fileRootPath + "/complaint/file/"+fileName;
                complaint.setCarryFile(fileUrl);
            }
            complaintService.saveComplaint(complaint);
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail("投诉失败");
        }
    }
}
