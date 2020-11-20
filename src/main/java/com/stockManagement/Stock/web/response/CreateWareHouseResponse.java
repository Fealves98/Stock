package com.stockManagement.Stock.web.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CreateWareHouseResponse {

    private Long idWareHouse;

    private String nameWareHouse;

    private Long idStore;
}
