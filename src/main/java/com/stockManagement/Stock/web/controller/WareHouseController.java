package com.stockManagement.Stock.web.controller;

import com.stockManagement.Stock.mapper.WareHouseMapper;
import com.stockManagement.Stock.service.WareHouseService;
import com.stockManagement.Stock.web.request.CreateWareHouseRequest;
import com.stockManagement.Stock.web.response.CreateWareHouseResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/wareHouse")
public class WareHouseController {

    private final WareHouseMapper mapper = WareHouseMapper.mapper;
    private final WareHouseService service ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastro de armazen")
    public CreateWareHouseResponse create(@RequestBody CreateWareHouseRequest request){
        log.info("m=create, request={}", request);
        final var dto = this.mapper.toDTO(request);
        final var response = this.service.create(dto);
        return this.mapper.toCreateResponse(response);
    }
}
