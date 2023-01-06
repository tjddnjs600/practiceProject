package com.example.demo.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "member")
@AllArgsConstructor
@Builder
@Data
public class MemberEntity {
    @Id
    private String user_id;

    private String user_pwd;

    private String user_class_cd;

    private String regist_dt;

    private String update_dt;

    public MemberEntity() {}
}
