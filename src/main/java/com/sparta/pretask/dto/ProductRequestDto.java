package com.sparta.pretask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    // 관심상품명
    private String title;
    // 관심상품 썸네일 image URL
    private String image;
    // 관심상품의 가격
    private int price;

    private int stock;
}
