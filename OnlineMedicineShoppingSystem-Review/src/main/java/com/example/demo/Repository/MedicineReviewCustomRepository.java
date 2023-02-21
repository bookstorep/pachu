package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reviews;

@Repository
public interface MedicineReviewCustomRepository {

	
	public List<Reviews> getReviewByRating(Double rating) throws Exception;
	@Query("from Reviews where reviewId >= :range1 and reviewId <= :range2")
	public List<Reviews> getReviewBetweenIds(@Param("range1") Integer range1,@Param("range2") Integer range2)throws Exception;
}
