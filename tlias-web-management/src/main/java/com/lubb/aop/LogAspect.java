package com.lubb.aop;

import com.alibaba.fastjson.JSONObject;
import com.lubb.mapper.OperateLogMapper;
import com.lubb.pojo.OperateLog;
import com.lubb.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect //切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.lubb.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人ID
        //获取请求头的JWT令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();


        //操作方法名
        String methodName = joinPoint.getSignature().getName();


        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        //操作方法返回值
        String returnValue = JSONObject.toJSONString(result);
        //操作耗时
        long end = System.currentTimeMillis();
        Long costTime = end - start;

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className,
                methodName, methodParams, returnValue, costTime);

        log.info("AOP记录操作日志：{}", operateLog);
        operateLogMapper.insert(operateLog);
        return result;
    }
}
