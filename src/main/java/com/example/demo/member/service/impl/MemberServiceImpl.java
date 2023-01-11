package com.example.demo.member.service.impl;

import com.example.demo.common.threadPool.ThreadPoolConfig;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    private ThreadPoolConfig threadPoolConfig;

    @Override
    public List<MemberEntity> selecList() {

        List<MemberEntity> list = this.memberRepository.findAll();

        Runnable r = () -> {
            this.memberRepository.save(MemberEntity.builder().user_id("ThreadUser").user_class_cd("F").user_pwd("1234").build());
            log.debug("userThread  : "+Thread.currentThread().getName());
        };

        this.threadPoolConfig.executor().execute(r);

        return list;
    }

    @Override
    public MemberVo selectUser(MemberVo memberVo) throws InvocationTargetException, IllegalAccessException {
        Optional<MemberEntity> memer = memberRepository.findAll().stream()
                .filter(id -> (id.getUser_id().equals(memberVo.getUser_id())
                                && id.getUser_pwd().equals(memberVo.getUser_pwd()))).findFirst();

        if(!memer.isPresent()){
            return null;
        }

        MemberVo resVo = new MemberVo();
        BeanUtils.copyProperties(resVo, memer.get());

        return resVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> insertUser(MemberVo memberVo) throws InvocationTargetException, IllegalAccessException {
        Map<String, String> resMsp = new HashMap<>();
        MemberEntity memberEntity = new MemberEntity();

        Optional<MemberEntity> checkEnt = memberRepository.findAll()
                .stream().filter(ck -> ck.getUser_id().equals(memberVo.getUser_id())).findFirst();

        if(checkEnt.isPresent()){
            resMsp.put("resCd","500");
            resMsp.put("resMsg","중복된ID");
            return resMsp;
        }

        BeanUtils.copyProperties(memberEntity, memberVo);

        MemberEntity resMemberEntity = memberRepository.save(memberEntity);

        if(ObjectUtils.isNotEmpty(resMemberEntity)){
            resMsp.put("resCd","200");
            resMsp.put("resMsg","저장성공");
        }

        return resMsp;
    }
}
