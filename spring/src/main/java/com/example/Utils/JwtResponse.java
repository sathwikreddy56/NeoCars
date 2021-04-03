package com.example.Utils;

public class JwtResponse {
	private String Token;
	private Boolean isAuth;
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public Boolean getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(Boolean isAuth) {
		this.isAuth = isAuth;
	}
	public JwtResponse(String token, Boolean isAuth) {
		Token = token;
		this.isAuth = isAuth;
	}
	
}
