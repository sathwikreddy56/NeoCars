package com.example.Utils.Security.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.AdminModel;
import com.example.repo.AdminRepository;


@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
	@Autowired
	AdminRepository adminRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AdminModel admin = adminRepository.findByEmail(email);
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
		return AdminDetailsImpl.build(admin);
	}

}
