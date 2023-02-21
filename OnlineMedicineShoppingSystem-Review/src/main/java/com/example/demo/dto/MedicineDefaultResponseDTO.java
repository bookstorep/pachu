package com.example.demo.dto;

import lombok.Data;

@Data
public class MedicineDefaultResponseDTO implements MyDTO {
	public MedicineDefaultResponseDTO(Long review_id2, Long user_id2, String description2, Double rating2) {
		// TODO Auto-generated constructor stub
	}
	public MedicineDefaultResponseDTO(Integer review_id2, Long user_id2, String description2, Double rating2) {
		// TODO Auto-generated constructor stub
	}
	private Integer review_id;
	private Long user_id;
	private String description;
	private Double rating;

}
