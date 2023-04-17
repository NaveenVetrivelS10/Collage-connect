package com.hubino.marksheet.utility;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hubino.marksheet.service.CustomUserServiceDetails;
@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil util;
	@Autowired
	private CustomUserServiceDetails customUserServiceDetails;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authenticateHeader=request.getHeader("SecretAPIKey");
		String token=null;
		String username=null;
		if(authenticateHeader !=null && authenticateHeader.startsWith("Bearer "))
		{
			token=authenticateHeader.substring(7);
			username=util.extractUsername(token);
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() ==null)
		{
			UserDetails userdetail=customUserServiceDetails.loadUserByUsername(username);
			if(util.validateToken(token, userdetail))
			{
				UsernamePasswordAuthenticationToken authenticationToken=new 
						UsernamePasswordAuthenticationToken(username,null, userdetail.getAuthorities());
				authenticationToken.setDetails(
						
						new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	

}
