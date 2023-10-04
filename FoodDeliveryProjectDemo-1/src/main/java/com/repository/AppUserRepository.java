package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	boolean existsByUsername(String username);
}
