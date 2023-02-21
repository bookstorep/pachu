package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Reviews;

@Service
public interface MedicineReviewService {
	public List<Reviews> getAllReviews()throws Exception;
	public Reviews insertReview(Reviews review)throws Exception;
     public Reviews updateReview(Reviews review)throws Exception;
     public void deleteByReviewId(Integer reviewId)  throws Exception;
 	
	
	public List<Reviews> getReviewByRating(Double rating) throws Exception;
	public List<Reviews> getReviewBetweenIds(Integer range1,Integer range2)throws Exception;
	public Reviews getReviewById(Integer searchedReviewId) throws Exception;;
	
	public List<Reviews>  sortByRatings()  throws Exception;


}
