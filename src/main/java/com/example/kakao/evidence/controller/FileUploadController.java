package com.example.kakao.evidence.controller;

import com.example.kakao.evidence.service.FileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RestController
public class FileUploadController {
    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
    @PostMapping("/fileupload")
    public String create(@RequestParam("multiPartfiles")List<MultipartFile> multipartFiles,
                         @RequestParam("user_email")String user_email)throws Exception {
        fileUploadService.save(multipartFiles, user_email);
        return "ok"; // MultipartFile 찾아보기
    }
}
