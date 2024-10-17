package com.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
	@NonNull
	private String bookId;     // 도서ID
	@NonNull
	private String bookName;      // 도서명
	@NonNull
	private int unitPrice;      // 가격
	@NonNull
	private String author;     // 저자
	private String description; // 설명
	private String publisher;   // 출판사
	private String category;    // 분류
	private long unitsInStock;  // 재고수
	private String releaseDate; // 출판일(월/년)
	private String condition;  // 신규/중고/전자 도서
}