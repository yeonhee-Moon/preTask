package com.sparta.pretask.service;

import com.sparta.pretask.dto.ProductRequestDto;
import com.sparta.pretask.dto.ProductResponseDto;
import com.sparta.pretask.entity.Product;
import com.sparta.pretask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }


    public ProductResponseDto getProduct(Long id) {

        Product product = findProduct(id);

        return new ProductResponseDto (product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        product.update(requestDto);

        return new ProductResponseDto(product);
    }


    public Long deleteProduct(Long id) {

        Product product = findProduct(id);


        productRepository.delete(product);

        return id;
    }

    private Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 상품은 존재하지 않습니다.")
        );
    }




}

