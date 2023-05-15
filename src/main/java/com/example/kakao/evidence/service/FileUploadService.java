package com.example.kakao.evidence.service;

import com.example.kakao.evidence.domain.Evidence;
import com.example.kakao.user_Info.domain.User;
import com.example.kakao.evidence.repository.FileUploadYnRepository;
import com.example.kakao.user_Info.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadService {
    private final FileUploadYnRepository fileUploadYnRepository;

    private final UserService userService;

    public FileUploadService(FileUploadYnRepository fileUploadYnRepository, UserService userService) {
        this.fileUploadYnRepository = fileUploadYnRepository;
        this.userService = userService;
    }
    public void save(List<MultipartFile> multipartFiles, String user_email) throws IOException {
        User user = userService.findByEmail(user_email);

        File folder = new File("/Users/teapot/Desktop/evidence/"+user_email); // 파일 저장 경로

        if (!folder.exists()){
            folder.mkdirs(); // 폴더 생성
        }

        String upLoadFolder = "/Users/teapot/Desktop/evidence/"+user_email;
        List<Evidence> lst = new ArrayList();
        for (MultipartFile multipartFile : multipartFiles){
            String upLoadFileName = multipartFile.getOriginalFilename();
            // 저장 파일, 생성자로 경로와 이름을 지정
            File saveFile = new File(upLoadFolder, upLoadFileName);
            multipartFile.transferTo(saveFile);
            String filePath = upLoadFolder+"/"+upLoadFileName;
            Evidence evidence = Evidence.builder()
                    .file_path(filePath)
                    .user(user)
                    .build();
            lst.add(evidence);
        }
        try {
            fileUploadYnRepository.saveAll(lst);
            user.setFileUploadYn("Y");
            userService.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
