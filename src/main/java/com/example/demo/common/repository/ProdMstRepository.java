package com.example.demo.common.repository;

import com.example.demo.common.entity.ProdMstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdMstRepository extends JpaRepository<ProdMstEntity, String> {
}
