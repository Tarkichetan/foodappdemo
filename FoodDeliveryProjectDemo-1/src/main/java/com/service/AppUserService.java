package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.entity.AppUser;
import com.repository.AppUserRepository;

import jakarta.validation.Valid;


@Service
@Validated
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }	

    public Optional<AppUser> getAppUserById(int userId) {
        return appUserRepository.findById(userId);
    }

    public AppUser createAppUser(@Valid AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser updateAppUser(int userId,@Valid AppUser updatedAppUser) {
        if (!appUserRepository.existsById(userId)) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AppUser not found");
        }
        updatedAppUser.setUserId(userId);
        return appUserRepository.save(updatedAppUser);
    }

    public void deleteAppUser(int userId) {
        appUserRepository.deleteById(userId);
    }
}