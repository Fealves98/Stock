package com.stockManagement.Stock.repository;

import com.stockManagement.Stock.entity.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouseEntity,Long> {
}
