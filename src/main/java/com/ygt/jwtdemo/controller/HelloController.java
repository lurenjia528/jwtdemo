package com.ygt.jwtdemo.controller;

import com.ygt.jwtdemo.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 测试控制器
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Map login(HttpServletRequest request){
        String token = request.getParameter("token");
        return  JwtUtil.validateToken(token);
    }
}