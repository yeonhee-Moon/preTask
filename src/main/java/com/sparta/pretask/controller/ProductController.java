package com.sparta.pretask.controller;

import com.sparta.pretask.dto.ProductRequestDto;
import com.sparta.pretask.dto.ProductResponseDto;
import com.sparta.pretask.security.UserDetailsImpl;
import com.sparta.pretask.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 응답 보내기
        return productService.getProducts(userDetails.getUser(),  page-1, size, sortBy, isAsc);
    }




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