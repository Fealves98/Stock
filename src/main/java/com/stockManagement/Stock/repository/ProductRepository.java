package com.stockManagement.Stock.repository;

import com.stockManagement.Stock.entity.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {

}
