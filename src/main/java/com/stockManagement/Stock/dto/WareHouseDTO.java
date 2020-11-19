package com.stockManagement.Stock.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WareHouseDTO {

    private Long idWareHouse;
    @ApiModelProperty(hidden = true)
    private String nameWareHouse;
}
