package com.stockManagement.Stock.web.controller;

import com.stockManagement.Stock.dto.ProductDTO;
import com.stockManagement.Stock.mapper.ProductMapper;
import com.stockManagement.Stock.service.ProductService;
import com.stockManagement.Stock.web.request.CreateProductRequest;
import com.stockManagement.Stock.web.request.RetrieveProductRequest;
import com.stockManagement.Stock.web.request.UpdateProductRequest;
import com.stockManagement.Stock.web.response.CreateProductResponse;
import com.stockManagement.Stock.web.response.RetrieveProductRespose;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class StockController {

    private final ProductMapper mapper = ProductMapper.mapper;
    private final ProductService service;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation("Cadastra Produto no sistema")
    public CreateProductResponse create(@RequestBody CreateProductRequest request) {
        log.info("m=create, request={}", request);
        final var dto = this.mapper.toDTO(request);
        final var response = this.service.create(dto);

        return this.mapper.toCreateResponse(response);
    }

    @GetMapping
    @ApiOperation("Realiza a busca dos produtos")
    public Page<RetrieveProductRespose> retrieveAll(final RetrieveProductRequest filter, @PageableDefault Pageable pageable) {
        log.info("m=retrieveAll, filter={}, pageable={}", filter, pageable);
        final var product = this.mapper.toDTO(filter);
        final var result = this.service.retrieve(product, pageable);
        return result.map(this.mapper::toResponse);
    }

    @PatchMapping("/{idProduct}")
    @ResponseStatus(NO_CONTENT)
    @ApiOperation("Atualiza um Produto")
    public void update(@PathVariable Long idProduct, @RequestBody UpdateProductRequest request) {
        log.info("m=update, idProduct={}, request={}", idProduct, request);

        final var dto = this.mapper.toDTO(request);
        this.service.alterProperties(idProduct, dto);

    }
}
