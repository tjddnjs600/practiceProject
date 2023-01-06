package com.example.demo.member.service;

import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.vo.MemberVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface MemberService {
    List<MemberEntity> selecList();

    MemberVo selectUser(MemberVo memberVo) throws InvocationTargetException, IllegalAccessException;

    Map<String, String> insertUser(MemberVo memberVo) throws InvocationTargetException, IllegalAccessException;
}
