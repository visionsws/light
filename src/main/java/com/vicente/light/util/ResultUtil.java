package com.vicente.light.util;

import com.vicente.light.common.CommonConstant;
import com.vicente.light.dto.ResponseDto;

/**
 * @author shiweisen
 * @since 2018-01-24
 */
public class ResultUtil {
    public static ResponseDto success(Object object){
        ResponseDto result = new ResponseDto();
        result.setCode(CommonConstant.RESPONSE_CODE_SUCCESS);
        result.setMsg("操作成功");
        result.setData(object);
        return result;
    }
    public static ResponseDto success(){
        return success(null);
    }

    public static ResponseDto error(String code,String msg){
        ResponseDto result = new ResponseDto();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
