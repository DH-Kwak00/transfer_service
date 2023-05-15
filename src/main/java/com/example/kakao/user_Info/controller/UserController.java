package com.example.kakao.user_Info.controller;

import com.example.kakao.user_Info.domain.User;
import com.example.kakao.user_Info.domain.UserDto;
import com.example.kakao.user_Info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//@responsebody 로 사용해야한다.
//파라미터 부분에는 @RequestBody 객체로 받아줘야 한다. >> Dto 만들어주기
//crud 패턴 연습

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    @ResponseBody
    public String create(@RequestBody UserDto userDto){
//        boolean evidence = false;
//        if(userDto.getEvidence().equals("true")){
//            evidence = true;
//        }
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password((userDto.getPassword()))
                .fileUploadYn(userDto.getFileUploadYn())
                .userRate(userDto.getUserRate())
                .build();
        userService.save(user);
        return "ok";
    }

}
