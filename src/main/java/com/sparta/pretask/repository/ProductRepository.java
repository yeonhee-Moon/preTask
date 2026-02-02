package com.sparta.pretask.repository;

import com.sparta.pretask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long > {
}
