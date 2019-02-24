package com.techprimers.security.springsecurityauthserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.security.springsecurityauthserver.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByuserName(String username);


	

}
