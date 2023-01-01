package com.example.demo.member.service.impl;

import com.example.demo.member.entity.Memeber;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Override
    public List<Memeber> selectUser() {
        return memberRepository.findAll();
    }
}
