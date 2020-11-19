package com.stockManagement.Stock.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wareHouse")
public class WareHouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_WareHouse")
    private Long idWareHouse;
    @Column(name = "name_WareHouse")
    private String nameWareHouse;

}
