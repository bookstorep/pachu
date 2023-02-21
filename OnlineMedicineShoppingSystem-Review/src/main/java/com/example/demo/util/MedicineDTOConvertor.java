package com.example.demo.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.dto.MedicineDefaultResponseDTO;
import com.example.demo.entity.Reviews;

@Component
@Scope("singleton")
public class MedicineDTOConvertor {

	
	public static MedicineDefaultResponseDTO  getUserDefaultDTO(Reviews review)
	{
		MedicineDefaultResponseDTO dto = new MedicineDefaultResponseDTO(
				review.getReviewId(),
				review.getUserid(),
				review.getDescription(),
				
				review.getRating());
								                
		return dto;
	}
}
