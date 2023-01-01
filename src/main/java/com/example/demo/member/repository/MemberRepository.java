package com.example.demo.member.repository;

import com.example.demo.member.entity.Memeber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Memeber, Integer> {
}
