package com.lubb.controller;


import com.lubb.pojo.Emp;
import com.lubb.pojo.Result;
import com.lubb.service.EmpService;
import com.lubb.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("用户登录{}", emp);
        Emp e = empService.login(emp);

        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误！");
    }
}
