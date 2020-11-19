package com.stockManagement.Stock.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
@JsonSerialize
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id_product")
    private Long idProduct;
    private String name;
    private String description;
    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    private Long amount;
    @ManyToOne(fetch = FetchType.EAGER)
 //   @JoinColumn(name = "idWareHouse", columnDefinition = "BIGINT",nullable = true)
    private WareHouseEntity wareHouse;

}
