package com.example.demo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Builder
@Table(name = "store_mst")
public class StoreMstEntity {
    @Id
    private String store_cd;
    private String store_nm;
    private String store_locate;
    private String regist_dt;
    private String update_dt;

    public StoreMstEntity(){}
}
