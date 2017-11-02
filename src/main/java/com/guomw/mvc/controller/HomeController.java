package com.guomw.mvc.controller;


import com.guomw.mvc.common.ApiResult;
import com.guomw.mvc.enums.ResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guomw
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public ApiResult jsonTest(){
       return ApiResult.resultWith(ResultCodeEnum.SUCCESS);
    }
}
