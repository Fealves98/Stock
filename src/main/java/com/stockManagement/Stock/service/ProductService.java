package com.stockManagement.Stock.service;

import com.stockManagement.Stock.dto.ProductDTO;
import com.stockManagement.Stock.entity.ProductEntity;
import com.stockManagement.Stock.mapper.ProductMapper;
import com.stockManagement.Stock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Error;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

import static org.springframework.data.domain.Example.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper mapper;
    private final ProductRepository repository;

    public ProductDTO create(final ProductDTO dto) {

        if (dto.getAmount() < 0) {

        }

        final var entity = this.mapper.toEntity(dto);
        final var product = this.repository.save(entity);
        return this.mapper.toDTO(product);

    }

    public Page<ProductDTO> retrieve(final ProductDTO dto, final Pageable pageable) {
        log.info("m=retrieve, dto={}, pageable={}", dto, pageable);
        final var example = of(this.mapper.toEntity(dto));
        final var result = this.repository.findAll(example, pageable);
        return result.map(this.mapper::toDTO);

    }
}
