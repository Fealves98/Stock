package com.stockManagement.Stock.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "wareHouse")
public class WareHouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_warehouse")
    private Long idWareHouse;

    @Column(name = "name_warehouse")
    private String nameWareHouse;

    @Column(name = "id_store")
    private Long idStore;



}
