package com.guomw.mvc.common;


import com.guomw.mvc.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @author guomw
 */
@Data
public class ApiResult {

    private int resultCode;
    private String resultMsg;
    private Object data;

    /**
     * @param resultCode code
     * @return ApiResult
     */
    public static ApiResult resultWith(ResultCodeEnum resultCode) {
        ApiResult result = new ApiResult();
        result.setResultCode(resultCode.getResultCode());
        result.setResultMsg(resultCode.getResultMsg());
        return result;
    }

    /**
     * @param resultCode code
     * @param resultData data
     * @return ApiResult
     */
    public static ApiResult resultWith(ResultCodeEnum resultCode, Object resultData) {
        ApiResult result = new ApiResult();
        result.setResultCode(resultCode.getResultCode());
        result.setResultMsg(resultCode.getResultMsg());
        result.setData(resultData);
        return result;
    }

    /**
     * @param resultCode code
     * @param resultMsg  msg
     * @param resultData data
     * @return ApiResult
     */
    public static ApiResult resultWith(ResultCodeEnum resultCode, String resultMsg, Object resultData) {
        ApiResult result = new ApiResult();
        result.setResultCode(resultCode.getResultCode());
        result.setResultMsg(resultMsg);
        result.setData(resultData);
        return result;
    }

}
