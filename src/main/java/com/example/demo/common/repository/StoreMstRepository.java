package com.example.demo.common.repository;

import com.example.demo.common.entity.StoreMstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreMstRepository extends JpaRepository<StoreMstEntity, String> {
}
