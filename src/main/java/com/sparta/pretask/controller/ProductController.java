package com.sparta.pretask.controller;

import com.sparta.pretask.dto.ProductRequestDto;
import com.sparta.pretask.dto.ProductResponseDto;
import com.sparta.pretask.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //등록
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {

        return productService.createProduct(requestDto);
    }

    //단건조회
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {

        ProductResponseDto response = productService.getProduct(id);

        return ResponseEntity.ok(response);
    }

    // 목록조회





    //수정
    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto) {

        return productService.updateProduct(id, requestDto);

    }

    //삭제
    @DeleteMapping("/products/{id}")
    public Long deleteMemo(@PathVariable Long id) {

        return productService.deleteProduct(id);
    }
}