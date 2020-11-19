package com.stockManagement.Stock.web.request;

import com.stockManagement.Stock.entity.WareHouseEntity;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private Long idProduct;
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    @Positive(message = "The quantity cannot be less than 0")
    private Long amount;
    private ProductWareHouseRequest wareHouse;

}
