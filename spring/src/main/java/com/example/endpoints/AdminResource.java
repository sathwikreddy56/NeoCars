package com.example.endpoints;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.Utils.JwtResponse;
import com.example.Utils.getemail;
import com.example.Utils.getid;
//import com.example.Utils.Security.Admin.AdminDetailsImpl;
import com.example.Utils.Security.jwt.Admin.AdminJwtUtils;
import com.example.model.AdminModel;
import com.example.model.CarModel;
import com.example.model.LoginModel;
import com.example.service.AdminService;
import com.example.service.CarService;

//Admin Resource
@RestController
@RequestMapping("/admin")
public class AdminResource {
	private final CarService carService ;
	private final AdminService adminService;
	
	public AdminResource(CarService carService,AdminService adminService) {
		this.carService = carService;
		this.adminService = adminService;
	}
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/dashboard")
	public ResponseEntity<?> dashboard(@RequestHeader ("Authorization") String token){
		String t = token.substring(7, token.length());
		Integer Eid = AdminService.grabEmail(t);
		System.out.println(Arrays.toString(CarService.getdashboard(Eid).toArray()));
		return new ResponseEntity<>(CarService.getdashboard(Eid),HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginModel ep) {
		JwtResponse out= new JwtResponse(null,false);
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(ep.getEmail(), ep.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = AdminJwtUtils.generateJwtToken(authentication);
			out.setIsAuth(true);
			out.setToken(jwt);
			return new ResponseEntity<>(out, HttpStatus.OK);
		}catch(AuthenticationException e) {
			out.setIsAuth(false);
			out.setToken(null);
			return new ResponseEntity<>(out, HttpStatus.UNAUTHORIZED);
		}
    }
	@PostMapping("/signup")//5
	public ResponseEntity<String> AddNewAdmin(@RequestBody AdminModel admin) {
		
		AdminModel newadmin = new AdminModel(
				admin.getEmail(),
				encoder.encode(admin.getPassword()),
				admin.getMobileNumber(),
				admin.getSellerName(),
				admin.getUserRole(),
				admin.getCompanyName(),
				admin.getCompanyImageURL(),
				admin.getCompanyAddress(),
				admin.getEarnings()
				);
				
				
		adminService.addAdminModel(newadmin);
		System.out.println("Admin Added");
        return new ResponseEntity<>("Admin Added", HttpStatus.OK);
    }
	@PostMapping("/addCar")  //4
	public ResponseEntity<String> addCar(@RequestBody CarModel car){
		Integer newCar = carService.addCarModel(car);
		if(newCar==0) {
			return new ResponseEntity<>("Car Already Present", HttpStatus.CONFLICT);
		}else return new ResponseEntity<>("Car Added", HttpStatus.CREATED);
	}
	@PostMapping("/editCar") //5
    public ResponseEntity<String> updateCar(@RequestBody CarModel car) {
		Integer updateCar = carService.updateCar(car);
		if(updateCar == 0 ) {
	        return new ResponseEntity<>("Car Edited", HttpStatus.OK);
		}else {
	        return new ResponseEntity<>("Car Not Found", HttpStatus.CONFLICT);
		}
    }
	@PostMapping("/deleteCar")//6
    public ResponseEntity<?> deleteCar(@RequestBody getid id) {
		System.out.println("in delete Car"+id.getId());
		carService.deleteCar(id);
        return new ResponseEntity<>("Car Deleted",HttpStatus.OK);
    }
	
	
	@PostMapping("/profile")//7
	public ResponseEntity<AdminModel> ProfileDetails(@RequestBody getemail id){
		System.out.println("in profile"+id.getEmail());
		AdminModel admin = AdminService.findAdminModelByadminID(id.getEmail());
		System.out.println(admin);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	@GetMapping("/editProfile")//8
	public ResponseEntity<AdminModel> getProfileDetails(@RequestBody getemail id){
		AdminModel admin = AdminService.findAdminModelByadminID(id.getEmail());
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	@PostMapping("/editProfile")//9
    public ResponseEntity<AdminModel> updateAdmin(@RequestBody AdminModel car) {
		AdminModel updateAdmin = adminService.updateAdmin(car);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
    }
	
}
