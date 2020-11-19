package com.stockManagement.Stock.web.request;

import lombok.Data;

import java.math.BigDecimal;
import java.text.Bidi;

@Data
public class UpdateProductRequest {

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    private ProductWareHouseRequest wareHouse;
}
