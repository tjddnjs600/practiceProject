package com.example.demo.member.service.impl;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.impl.MemberImpl;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Override
    public List<Member> selecList() {
        return memberRepository.findAll();
    }

    @Override
    public MemberVo selectUser(MemberVo memberVo) throws InvocationTargetException, IllegalAccessException {
        Optional<Member> memer = memberRepository.findAll().stream()
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
        Member member = new Member();

        Optional<Member> checkEnt = memberRepository.findAll()
                .stream().filter(ck -> ck.getUser_id().equals(memberVo.getUser_id())).findFirst();

        if(checkEnt.isPresent()){
            resMsp.put("resCd","500");
            resMsp.put("resMsg","중복된ID");
            return resMsp;
        }

        BeanUtils.copyProperties(member, memberVo);

        Member resMember = memberRepository.save(member);

        if(ObjectUtils.isNotEmpty(resMember)){
            resMsp.put("resCd","200");
            resMsp.put("resMsg","저장성공");
        }

        return resMsp;
    }
}
