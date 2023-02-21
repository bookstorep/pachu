package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reviews;
@Repository
public interface MedicineReviewRepository extends JpaRepository<Reviews, Integer>,MedicineReviewCustomRepository {

	

	

}
