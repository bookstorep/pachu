package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reviews;
import com.example.demo.service.MedicineReviewService;

@RestController
@RequestMapping("/reviews")
public class MedicineReviewRestController {

	@Autowired
	MedicineReviewService service;
	//localhost:8001/reviews/sort/points
	@GetMapping("/sort/points")
	public List<Reviews> sortingByRating() throws Exception
	{
		return  service.sortByRatings();
	}
	
}
