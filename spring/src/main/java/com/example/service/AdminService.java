package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import com.example.Utils.allcompanies;
import com.example.Utils.getemail;
import com.example.Utils.Security.jwt.User.UserJwtUtils;
import com.example.model.AdminModel;
import com.example.repo.AdminRepository;
@Service
@Transactional
public class AdminService {
	private static  AdminRepository adminRepo;
	@Autowired
	public AdminService(AdminRepository adminRepo) {
		AdminService.adminRepo = adminRepo;
	}
	public static AdminModel findAdminModelByadminID(String email) {
		return adminRepo.findByEmail(email);
	}
	public AdminModel updateAdmin(AdminModel admin) {
		return adminRepo.save(admin);
	}
	public void deleteAdmin(getemail id) {
		System.out.println(id.getEmail());
		adminRepo.deleteByEmail(id.getEmail());
	}
	public String addAdminModel(AdminModel admin) {
		AdminModel check = adminRepo.findByEmail(admin.getEmail());
		if(check == null) {
			adminRepo.save(admin);
			return "Admin added";
		}else {
			return "Email already in use";
		}
	}
	public ArrayList<allcompanies> listCompanies (){
		ArrayList<allcompanies> companies = new ArrayList<>();
		for(AdminModel admins :adminRepo.findAll()) {
			allcompanies company = new allcompanies();
			company.setCompanyAddress(admins.getCompanyAddress());
			company.setCompanyImageURL(admins.getCompanyImageURL());
			company.setCompanyName(admins.getCompanyName());
			if(!companies.contains(company))companies.add(company);
		}
		return companies;
	}
	public static Integer grabEmail(String jwt) {
		String username = UserJwtUtils.getUserNameFromJwtToken(jwt);
		AdminModel admin = findAdminModelByadminID(username);
		return admin.getAdminID();
	}
}
