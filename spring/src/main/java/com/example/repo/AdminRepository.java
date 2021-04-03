package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {

	Optional<AdminModel> findByadminID(String id);
	
	void deleteByadminID(String  id);
	void deleteByEmail(String email);
	AdminModel findByEmail(String email);
}
