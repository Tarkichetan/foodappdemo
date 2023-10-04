package com.controller;

import java.util.List;
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AppUser;
import com.service.AppUserService;

@RestController
@RequestMapping("/api/appusers")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @GetMapping("/{userId}")
    public Optional<AppUser> getAppUserById(@PathVariable int userId) {
        return appUserService.getAppUserById(userId);
    }

    @PostMapping
    public AppUser createAppUser(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("/{userId}")
    public AppUser updateAppUser(@PathVariable int userId, @Valid @RequestBody AppUser updatedAppUser) {
        return appUserService.updateAppUser(userId, updatedAppUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteAppUser(@PathVariable int userId) {
        appUserService.deleteAppUser(userId);
    }

}
