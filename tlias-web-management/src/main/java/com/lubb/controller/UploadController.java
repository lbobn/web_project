package com.lubb.controller;

import com.lubb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传");
        //springboot 中默认单个文件最大为1M

        String originalFilename = image.getOriginalFilename();//获取文件原始名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFIleName = UUID.randomUUID().toString() + extname;
        log.info("新文件名{}", newFIleName);

        //
        image.transferTo(new File("E:\\" + newFIleName));
        return Result.success();
    }
}
