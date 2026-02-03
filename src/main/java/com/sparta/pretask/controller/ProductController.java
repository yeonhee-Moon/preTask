package com.sparta.pretask.controller;

import com.sparta.pretask.dto.ProductRequestDto;
import com.sparta.pretask.dto.ProductResponseDto;
import com.sparta.pretask.security.UserDetailsImpl;
import com.sparta.pretask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProductController {


    private final ProductService productService;



    //등록
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {

        return productService.createProduct(requestDto);
    }

    //단건조회
    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {

        return productService.getProduct(id);

    }

    //목록조회
    @GetMapping("/productsAll")
    public List<ProductResponseDto> getProducts() {

        return productService.getProducts();
    }

    // 주문목록조회
    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

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

    //주문 생성(재고 차감)
    @PostMapping("/{id}/decrease")
    public ResponseEntity<String> decreaseStock(
            @PathVariable Long id,
            @RequestParam int qty) {

        productService.decreaseStock(id, qty);

        return ResponseEntity.ok("재고 차감 성공");
    }

}