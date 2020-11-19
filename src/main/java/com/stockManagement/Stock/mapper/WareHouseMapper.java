package com.stockManagement.Stock.mapper;

import com.stockManagement.Stock.dto.WareHouseDTO;
import com.stockManagement.Stock.entity.WareHouseEntity;
import com.stockManagement.Stock.web.request.CreateWareHouseRequest;
import com.stockManagement.Stock.web.response.CreateWareHouseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WareHouseMapper {
    
    WareHouseMapper mapper = Mappers.getMapper(WareHouseMapper.class);

    WareHouseDTO toDTO(CreateWareHouseRequest request);

    WareHouseEntity toEntity(WareHouseDTO dto);

    WareHouseDTO toDTO(WareHouseEntity wareHouse);

    CreateWareHouseResponse toCreateResponse(WareHouseDTO response);

    WareHouseDTO toDTO(WareHouseDTO response);
}
