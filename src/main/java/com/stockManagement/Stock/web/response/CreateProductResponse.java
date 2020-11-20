package com.stockManagement.Stock.web.response;

import com.stockManagement.Stock.entity.WareHouseEntity;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class CreateProductResponse {

    private Long idProduct;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    private Long amount;

    private WareHouseEntity wareHouse;


}
