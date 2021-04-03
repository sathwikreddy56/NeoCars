package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Long> {
	Optional<CarModel> findBycarID(Integer id);
	void deleteByCarID(Integer carID);

	
}
