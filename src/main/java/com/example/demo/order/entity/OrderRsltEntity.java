package com.example.demo.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "order_rslt")
public class OrderRsltEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rslt_no;
    private String ord_stat;
    private String store_nm;
    private String ord_user_id;
    private String prod_cd;
    private String prod_nm;
    private String ord_prod_qaty;
    private String regist_dt;
    private String update_dt;

    public OrderRsltEntity(){}
}
