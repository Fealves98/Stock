package com.stockManagement.Stock.dto;

import com.stockManagement.Stock.entity.WareHouseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long idProduct;
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Long amount;
    private WareHouseEntity wareHouse;

}
