package com.stockManagement.Stock.web.request;

import lombok.Data;


@Data
public class RetrieveProductRequest {

    private Long idProduct;
    private String name;
}
