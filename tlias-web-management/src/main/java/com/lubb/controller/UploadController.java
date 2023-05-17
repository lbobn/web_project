package com.lubb.controller;

import com.lubb.pojo.Result;
import com.lubb.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    //本地存储
    /*@PostMapping("upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传{},{},{}", username, age, image);
        //springboot 中默认单个文件最大为1M

        String originalFilename = image.getOriginalFilename();//获取文件原始名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFIleName = UUID.randomUUID().toString() + extname;


        log.info("新文件名{}", newFIleName);

        //
        image.transferTo(new File("E:\\" + newFIleName));
        return Result.success();
    }*/

    //阿里云oss
    @PostMapping("upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}", image.getOriginalFilename());

        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功，文件URL:{}", url);

        return Result.success(url);

    }
}
