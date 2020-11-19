package com.stockManagement.Stock.mapper;

import com.stockManagement.Stock.dto.ProductDTO;
import com.stockManagement.Stock.entity.ProductEntity;
import com.stockManagement.Stock.web.request.CreateProductRequest;
import com.stockManagement.Stock.web.request.RetrieveProductRequest;
import com.stockManagement.Stock.web.request.UpdateProductRequest;
import com.stockManagement.Stock.web.response.CreateProductResponse;
import com.stockManagement.Stock.web.response.RetrieveProductRespose;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(final ProductEntity entity);

    ProductDTO toDTO(final RetrieveProductRequest request);

    ProductDTO toDTO(final CreateProductRequest request);

    ProductEntity toEntity(ProductDTO dto);

    CreateProductResponse toCreateResponse(ProductDTO response);

    RetrieveProductRespose toResponse( final ProductDTO dto);

    ProductDTO toDTO(UpdateProductRequest request);
}
