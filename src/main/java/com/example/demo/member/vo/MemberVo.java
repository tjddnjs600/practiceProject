package com.example.demo.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {
    private String user_id;
    private String user_pwd;
    private String user_class_cd;
    private String regist_dt;
    private String update_dt;
}
