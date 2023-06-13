package com.lubb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    /*
     * 测试JWT令牌生成
     * */
    @Test
    public void testGenJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "lubb")//签名算法,lubb:秘钥
                .setClaims(claims)//自定义内容，载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期1h
                .compact();
        System.out.println(jwt);
    }


    /*@Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("lubb")//指定签名秘钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NTAyNzYzNn0.oHtOr1fMEVforVgaVyZaO1uVVbYXIvLythhVisLeXsI")
                .getBody();
        System.out.println(claims);
    }*/

}
