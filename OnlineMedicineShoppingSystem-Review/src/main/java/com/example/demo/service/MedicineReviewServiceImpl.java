package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MedicineReviewRepository;
import com.example.demo.comparator.SortReviewByRatingHighToLow;
import com.example.demo.entity.Reviews;

@Service
public class MedicineReviewServiceImpl implements MedicineReviewService {
	
	@Autowired
	MedicineReviewRepository userRepository;

	@Override
	public List<Reviews> getAllReviews() throws Exception {
		List<Reviews> allReview = userRepository.findAll();
		return allReview;
	}

	@Override
	public Reviews insertReview(Reviews review) throws Exception {
		Reviews savedReview =  userRepository.save(review);  // Note :  save() is already implemented by Spring Data JPA
		if(savedReview != null)
		{
			return savedReview;
		}
		else return null;
	}

	@Override
	public Reviews updateReview(Reviews review) throws Exception {
		Reviews savedReview=userRepository.save(review);
		return savedReview;
	}

	
	
		@Override
	public List<Reviews> getReviewBetweenIds(Integer range1,  Integer range2) throws Exception {
			return  userRepository.getReviewBetweenIds(range1, range2);
	}
		@Override
	public List<Reviews> sortByRatings() throws Exception {
		List<Reviews> list =userRepository.findAll();
		List<Reviews> review=new ArrayList<>();
		Collections.sort(list,new SortReviewByRatingHighToLow());
		return list;	}

	@Override
	public List<Reviews> getReviewByRating(Double rating) throws Exception {
		List<Reviews> savedReview=userRepository.getReviewByRating(rating);
		return savedReview;
		}

	@Override
	public void deleteByReviewId(Integer reviewId) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteById(reviewId);
		
	}

	@Override
	public Reviews getReviewById(Integer searchedReviewId) throws Exception {
		Reviews savedReview = userRepository.getReferenceById(searchedReviewId);
		System.out.println("-->> inside Service Impl "+savedReview);
		return savedReview;
	}
}
	