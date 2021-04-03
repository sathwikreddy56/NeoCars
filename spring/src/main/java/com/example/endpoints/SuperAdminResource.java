package com.example.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Utils.JwtResponse;
import com.example.Utils.getemail;
import com.example.Utils.Security.jwt.Admin.AdminJwtUtils;
import com.example.model.LoginModel;
import com.example.service.AdminService;
import com.example.service.UserService;

//SuperAdmin Resource
@RestController
@RequestMapping("/super")
public class SuperAdminResource {
	
	private final UserService userService ;
	private final AdminService adminService;
	
	public SuperAdminResource(UserService userService,AdminService adminService) {
		this.userService = userService;
		this.adminService = adminService;
	}
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
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

	@PostMapping("/deleteAdmin")//6
    public ResponseEntity<?> deleteAdmin(@RequestBody getemail email) {
		adminService.deleteAdmin(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	@PostMapping("/deleteUser")//6
    public ResponseEntity<?> deleteUser(@RequestBody String email) {
		userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
