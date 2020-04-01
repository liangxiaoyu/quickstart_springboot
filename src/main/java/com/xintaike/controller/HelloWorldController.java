package com.xintaike.controller;

import com.xintaike.async.AsyncService;
import com.xintaike.entity.Car;
import com.xintaike.properties.ExtraProperties;
import com.xintaike.properties.OriginProperties;
import com.xintaike.redis.StringRedisTemplateWrapper;
import com.xintaike.service.HelloWorldService;
import com.xintaike.utils.CommonUtils;
import com.xintaike.utils.ResponseMessage;
import com.xintaike.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.Date;

/**
 * Created by jay on 2020/4/1.
 */
@RequestMapping("/helloworld")
@Controller
public class HelloWorldController {


    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private StringRedisTemplateWrapper stringRedisTemplateWrapper;

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    @ResponseBody
    public ResponseMessage hello(HttpServletRequest request){
        return ResponseMessage.success("hello world !!! Now is " + new Date().toString());
    }

    @GetMapping("/find")
    @ResponseBody
    public ResponseMessage find(){
        return ResponseMessage.success(helloWorldService.find());
    }

    @GetMapping("/test")
    @ResponseBody
    public ResponseMessage test(){


        return ResponseMessage.success("test !!! Now is " + new Date().toString());
    }


}
