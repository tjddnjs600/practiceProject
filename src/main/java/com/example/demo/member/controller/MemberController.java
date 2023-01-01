package com.example.demo.member.controller;

import com.example.demo.member.entity.Memeber;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/test")
public class MemberController {

    private MemberService memberService;

    @GetMapping(value = "/selectUser")
    public List<Memeber> selecList (){
        List<Memeber> list = memberService.selectUser();
        return list;
    }
}
