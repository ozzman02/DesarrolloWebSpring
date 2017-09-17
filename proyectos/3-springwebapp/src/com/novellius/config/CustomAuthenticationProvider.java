package com.novellius.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailService customUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		/*
		 * Datos del formulario de login
		 */
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null) {
			if (credentials.equals(user.getPassword())) {
				System.out.println("Login correcto");
				return new UsernamePasswordAuthenticationToken(principal, credentials, user.getAuthorities());
			} else {
				System.out.println("Error de login: " + principal);
				throw new BadCredentialsException("Error de login");
			}
		} else {
			System.out.println("Error de login: " + principal);
			throw new BadCredentialsException("Error de login");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}