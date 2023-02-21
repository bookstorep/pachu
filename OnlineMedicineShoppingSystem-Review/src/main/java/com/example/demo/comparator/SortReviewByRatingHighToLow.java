package com.example.demo.comparator;

import java.util.Comparator;

import com.example.demo.entity.Reviews;

public class SortReviewByRatingHighToLow implements Comparator<Reviews>{
	@Override
	public  int compare(Reviews o1, Reviews o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getRating()-o1.getRating());
	}
}
