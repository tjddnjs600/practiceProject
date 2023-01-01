package com.example.demo.member.service;

import com.example.demo.member.entity.Memeber;

import java.util.List;

public interface MemberService {
    List<Memeber> selectUser();
}
