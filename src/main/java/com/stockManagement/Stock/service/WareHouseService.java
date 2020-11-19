package com.stockManagement.Stock.service;

import com.stockManagement.Stock.dto.WareHouseDTO;
import com.stockManagement.Stock.entity.WareHouseEntity;
import com.stockManagement.Stock.exception.ResourceNotFoundException;
import com.stockManagement.Stock.mapper.WareHouseMapper;
import com.stockManagement.Stock.repository.WareHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WareHouseService {

    private final WareHouseMapper mapper;
    private final WareHouseRepository repository;

    public WareHouseDTO create(final WareHouseDTO dto){

        final var entity = this.mapper.toEntity(dto);
        final var wareHouse = this.repository.save(entity);
        return this.mapper.toDTO(wareHouse);
    }

    public WareHouseDTO retrieve(WareHouseEntity wareHouse) {
        log.info("m=retrieve, idWareHouse={}", wareHouse.getIdWareHouse());
        final var response = this.repository.findById(wareHouse.getIdWareHouse());

        if(response.isEmpty()){
            throw new ResourceNotFoundException("Id WareHouse not found: " + wareHouse.getIdWareHouse());
        }
        return this.mapper.toDTO(response.get());
    }
}
