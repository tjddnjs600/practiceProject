package com.example.demo.member.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/*다중키 entity 생성시 다중키 따로 정의
* repository에도 이 클래스 선언 ex) <Member, MemberImpl>
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MemberImpl implements Serializable {
    private int user_no;
    private String user_id;
}
