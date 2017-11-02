package com.guomw.mvc.controller.api;

import com.guomw.mvc.common.ApiResult;
import com.guomw.mvc.enums.ResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guomw
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    /**
     * 登录接口
     *
     * @param loginName
     * @param loginPassword
     * @return
     */
    @RequestMapping("/user/login")
    @ResponseBody
    ApiResult login(String loginName, String loginPassword){
        return ApiResult.resultWith(ResultCodeEnum.SUCCESS,loginName+loginPassword);
    }


}
