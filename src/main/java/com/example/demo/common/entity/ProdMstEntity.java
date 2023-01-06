package com.example.demo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "product_mst")
public class ProdMstEntity {

    @Id
    private String prod_cd;
    private String prod_nm;
    private String regist_dt;
    private String update_dt;
    private String prod_cate;

    public ProdMstEntity() {}
}
