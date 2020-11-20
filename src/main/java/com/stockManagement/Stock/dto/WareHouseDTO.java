package com.stockManagement.Stock.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WareHouseDTO {

    private Long idWareHouse;

    private String nameWareHouse;

    private Long idStore;
}
