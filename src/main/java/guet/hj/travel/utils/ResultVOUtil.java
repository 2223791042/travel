package guet.hj.travel.utils;


import guet.hj.travel.VO.ResultVO;
import guet.hj.travel.enums.ResultEnum;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO success(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO fail(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.FAIL.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO fail(){
        return fail("失败");
    }
}
