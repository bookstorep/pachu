package com.example.demo.dto;

import lombok.Data;

@Data

public class MedicinePostCreatedResponseDTO implements MyDTO {

	private Long review_id;
	private Long user_id;
	private String description;
	private Double rating;

}
