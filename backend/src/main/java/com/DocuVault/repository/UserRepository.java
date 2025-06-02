package com.DocuVault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DocuVault.entity.User;

public interface UserRepository extends JpaRepository<User ,Long>{

	boolean existsByEmail(String email);

}
