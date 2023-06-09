package com.lubb.filter;

import com.alibaba.fastjson.JSONObject;
import com.lubb.pojo.Result;
import com.lubb.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求的url
        String url = request.getRequestURL().toString();
        log.info("请求的url，{}", url);
        //判断请求中是否含有login，如果有放行
        if (url.contains("login")) {
            log.info("登录操作");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //获取jwt，判断是否存在，
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength("jwt")) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");

            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        //解析jwt令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");

            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        //放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }


}
