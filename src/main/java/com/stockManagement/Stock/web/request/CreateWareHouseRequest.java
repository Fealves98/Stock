package com.stockManagement.Stock.web.request;

import lombok.Data;

@Data
public class CreateWareHouseRequest {

    private Long idWareHouse;

    private String nameWareHouse;

    private Long idStore;

}
