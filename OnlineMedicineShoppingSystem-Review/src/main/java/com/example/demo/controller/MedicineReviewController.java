package com.example.demo.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicineDefaultResponseDTO;
import com.example.demo.dto.MyDTO;
import com.example.demo.entity.Reviews;
import com.example.demo.service.MedicineReviewService;
import com.example.demo.util.MedicineDTOConvertor;


@RestController
@RequestMapping("/review")
public class MedicineReviewController {
	@Autowired
	MedicineReviewService service;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/addreview")
	public ResponseEntity<String> addReview(@RequestBody Reviews review)
	{
		
		try {
			Reviews savedReview = service.insertReview(review);
			String responseMsg = "save with ReviewId"+savedReview.getReviewId()+"save with description"+savedReview.getDescription()+"save with rating"+savedReview.getRating();

			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com \n "+e  ;
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	//localhost:8001/review/update/1
	@PutMapping("/update/{reviewId}")
	public  Reviews updateReview(@RequestBody Reviews reviewDetails) throws Exception{
		return service.updateReview(reviewDetails);
	}
	
	//localhost:8001/review/allreviews
	@GetMapping("/allreviews")
	public List<Reviews> getAllreviews()
	{
		try {
			List<Reviews> allExtractedReviews = service.getAllReviews();
			return allExtractedReviews;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	//localhost:8001/review/reviewId/1
	@GetMapping("/reviewId/{reviewId}")
	public ResponseEntity<MyDTO> getReviewByReviewId(@PathVariable int reviewId) throws Exception
	{
		Reviews review=service.getReviewById(reviewId);
		MedicineDefaultResponseDTO dtoResp=MedicineDTOConvertor.getUserDefaultDTO(review);
		return new ResponseEntity<MyDTO>(dtoResp,HttpStatus.OK);
		
	}
	//localhost:8001/review/delete/1
	@DeleteMapping("/delete/{reviewId}")
	public  void deleteReview(@PathVariable int reviewId) throws Exception
	{
		try {
			service.deleteByReviewId(reviewId);
			mylogs.info("A value is deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//localhost:8001/review/title/good
	
	//localhost:8001/review/points/2
	@GetMapping("/points/{points}")
	public  List<Reviews> getReviewByPoints(@PathVariable Double points) throws Exception
	{
		return service.getReviewByRating(points);
	}
	
	//localhost:8001/review/reviewsById?r1=1&r2=3
	@GetMapping("/reviewsById")
	public List<Reviews> reviewByReviewId(@RequestParam Integer r1, @RequestParam  Integer r2) throws Exception
	{
		return service.getReviewBetweenIds(r1, r2);
	}
	
	
	
	
	
}
