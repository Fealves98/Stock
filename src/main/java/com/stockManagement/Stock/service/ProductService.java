package com.stockManagement.Stock.service;

import com.stockManagement.Stock.dto.ProductDTO;
import com.stockManagement.Stock.entity.ProductEntity;
import com.stockManagement.Stock.entity.WareHouseEntity;
import com.stockManagement.Stock.exception.ConstraintViolationException;
import com.stockManagement.Stock.exception.Exception;
import com.stockManagement.Stock.exception.ResourceNotFoundException;
import com.stockManagement.Stock.mapper.ProductMapper;
import com.stockManagement.Stock.mapper.WareHouseMapper;
import com.stockManagement.Stock.repository.ProductRepository;
import com.stockManagement.Stock.repository.WareHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static org.springframework.data.domain.Example.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final WareHouseRepository wareHouseRepository;
    private final WareHouseMapper wareHouseMapper;


    public ProductDTO create(final ProductDTO dto) {
        var search = this.retrieveByIdWareHouse(dto.getWareHouse().getIdWareHouse());
        final var entity = this.productMapper.toEntity(dto);
        final var product = this.productRepository.save(entity);
        return this.productMapper.toDTO(product);
    }

    public Page<ProductDTO> retrieve(final ProductDTO dto, final Pageable pageable) {
        log.info("m=retrieve, dto={}, pageable={}", dto, pageable);
        final var example = of(this.productMapper.toEntity(dto));
        final var result = this.productRepository.findAll(example, pageable);
        return result.map(this.productMapper::toDTO);
    }

    public void alterProperties(Long idProduct, ProductDTO dto) {
        log.info("m=alterProperties, idProduct={}, dto={}", idProduct, dto);
        var entity = this.retrieveById(idProduct);
        var search = this.retrieveByIdWareHouse(dto.getWareHouse().getIdWareHouse());
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getPurchasePrice() != null) {
            entity.setPurchasePrice(dto.getPurchasePrice());
        }
        if (dto.getSalePrice() != null) {
            entity.setSalePrice(dto.getSalePrice());
        }
        if (dto.getWareHouse().getIdWareHouse() != null) {
            final var wareHouse = this.wareHouseMapper.toEntity(dto.getWareHouse());
            wareHouse.setIdWareHouse(dto.getWareHouse().getIdWareHouse());
            entity.setWareHouse(wareHouse);
        }
        this.productRepository.save(entity);
    }

    public void delete(final Long idProduct) {
        final var entity = this.retrieveById(idProduct);
        this.productRepository.delete(entity);
    }

    private ProductEntity retrieveById(Long idProduct) {
        return this.productRepository.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product not Found " + idProduct));
    }

    private WareHouseEntity retrieveByIdWareHouse(Long idWareHouse) {
        return this.wareHouseRepository.findById(idWareHouse)
                .orElseThrow(() -> new ResourceNotFoundException("Informed WareHouse does not exist"));
    }
}



