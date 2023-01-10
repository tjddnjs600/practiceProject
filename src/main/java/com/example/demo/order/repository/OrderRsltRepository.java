package com.example.demo.order.repository;

import com.example.demo.order.entity.OrderRsltEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRsltRepository extends JpaRepository<OrderRsltEntity, Integer> {
}
