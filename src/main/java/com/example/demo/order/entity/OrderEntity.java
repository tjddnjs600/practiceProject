package com.example.demo.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "order_info")
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ord_no;

    private String store_cd;
    private String store_nm;
    private String ord_user_id;
    private String prod_cd;
    private String prod_nm;
    private String ord_prod_qaty;
    private String order_locat;
    private String user_class_cd;
    private String regist_dt;
    private String update_dt;
    private String ord_stat;

    public OrderEntity() {}

}
