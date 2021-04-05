package com.example.endpoints;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.Utils.GetCompanyCars;
import com.example.Utils.JwtResponse;
import com.example.Utils.getid;
import com.example.Utils.Security.jwt.User.UserJwtUtils;
import com.example.model.CarModel;
import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.example.service.AdminService;
import com.example.service.CarService;
import com.example.service.UserService;

//User Resource
@RestController
@RequestMapping("/user")
public class UserResource {
	private final CarService carService ;
	private final UserService userService;
	private final AdminService adminService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	
	public UserResource(CarService carService,UserService userService, AdminService adminService) {
		this.carService = carService;
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginModel ep) {
		JwtResponse out= new JwtResponse(null,false);
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(ep.getEmail(), ep.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = UserJwtUtils.generateJwtToken(authentication);
			out.setIsAuth(true);
			out.setToken(jwt);
			return new ResponseEntity<>(out, HttpStatus.OK);
		}catch(AuthenticationException e) {
			out.setIsAuth(false);
			out.setToken(null);
			return new ResponseEntity<>(out, HttpStatus.OK);
		}
    }
	@GetMapping("/dashboard")
	public ResponseEntity<?> dashboard(){
		return new ResponseEntity<>(adminService.listCompanies(),HttpStatus.OK);
		
	}
	@PostMapping("/signup")//5
	public ResponseEntity<String> AddNewUser(@RequestBody UserModel user) {
		UserModel newU = new UserModel(user.getEmail(),encoder.encode(user.getPassword()),
				user.getUsername(),user.getMobileNumber(),user.getAge(),user.getUserRole());
		userService.addUserModel(newU);
		System.out.println("User Added");
        return new ResponseEntity<>("User Added" , HttpStatus.OK);
    }
	@PostMapping("/cars")//4
    public ResponseEntity<List<CarModel>> GetCompanyCars(@RequestBody GetCompanyCars req) {
		List<CarModel> cars = carService.findAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
	@PostMapping("/carDetails")//5
    public ResponseEntity<?> CarDetails(@RequestBody getid id){
		System.out.println("in carDetails "+id.getId());
		Optional<CarModel> admin = carService.findByCarId(id);
		if(admin.isEmpty()) {
			return new ResponseEntity<>("Car Not Found", HttpStatus.CONFLICT);
		}else {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		}
		
	}
	
}
