package com.example.demo.member.controller;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private MemberService memberService;

    @GetMapping(value = "/selectUserList")
    public List<MemberEntity> selecList (){
        List<MemberEntity> list = memberService.selecList();
        return list;
    }

    @GetMapping(value = "/selectUser/{user_id}/{user_pwd}")
    public MemberVo selecUser (MemberVo memberVo) throws InvocationTargetException, IllegalAccessException {
        MemberVo userVo = memberService.selectUser(memberVo);
        return userVo;
    }

    @PostMapping(value = "/insertUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> insertUser (@RequestBody MemberVo memberVo) throws InvocationTargetException, IllegalAccessException {
        return memberService.insertUser(memberVo);
    }
}
