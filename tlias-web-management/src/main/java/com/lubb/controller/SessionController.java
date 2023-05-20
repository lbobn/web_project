package com.lubb.controller;

import com.lubb.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    //设置cookie
    @GetMapping("/c1")
    public Result cookies(HttpServletResponse response) {
        response.addCookie(new Cookie("login_name", "lubb"));
        return Result.success();
    }

    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_name")) {
                System.out.println("login_name: " + cookie.getValue());
            }

        }
        return Result.success();
    }
}
