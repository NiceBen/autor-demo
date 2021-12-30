package com.ofben.autordemo.response.controller;

import com.google.common.collect.Maps;
import com.ofben.autordemo.response.model.User;
import com.ofben.autordemo.response.resp.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

/**
 * TODO
 *
 * @date 2021-12-29
 * @since TODO
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getUserName1")
    public String getUserName1(){
        return "HuaGe";
    }

    @GetMapping("/getUserNameException")
    public static String getUserName(){
        HashMap hashMap = Maps.newHashMap();
        return hashMap.get(0).toString();
    }

    @GetMapping("/getUserNameAuthorException")
    public static String getUserNameException(){
        boolean flag = new Random().nextBoolean();
        if (flag) {
            throw new AuthorizationException();
        }
        return "hello world";
    }

    @GetMapping("/getUserName2")
    public Result getUserName2(){
        return Result.success("huage");
    }

    @GetMapping("/getUser1")
    public User getUser1(){
        return new User("HuaGe",18,"男");
    }
}
