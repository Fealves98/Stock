package com.stockManagement.Stock.service;

import com.stockManagement.Stock.dto.WareHouseDTO;
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
}
