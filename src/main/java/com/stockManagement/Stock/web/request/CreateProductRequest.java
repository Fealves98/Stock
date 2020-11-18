package com.stockManagement.Stock.web.request;

import com.stockManagement.Stock.entity.WareHouseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private Long idProduct;
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Long amount;
    private WareHouseEntity wareHouse;

}
