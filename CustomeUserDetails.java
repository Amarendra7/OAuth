package com.techprimers.security.springsecurityauthserver.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomeUserDetails extends Users implements UserDetails {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6070312991398179161L;

	public CustomeUserDetails(final Users users) {
		super(users);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<Role> objRole=new HashSet<>();
		Role objDataRole=new Role();
		objDataRole.setRoleName("ADMIN");
		objRole.add(objDataRole);
			return	objRole
					.stream()
					.map(role -> new SimpleGrantedAuthority("ROLE"+role.getRoleName()))
					.collect(Collectors.toList());
			
		
	
		// TODO Auto-generated method stub
	
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
