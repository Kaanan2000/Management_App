package com.kaanan.management_app.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/management")
@PreAuthorize("hasRole('MANAGER')")
public class ManagementController {

    @GetMapping
    @PreAuthorize("hasAuthority('management:read')")
    public String get() {
        return "GET:: management controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('management:create')")
    public String post() {
        return "POST:: management controller";
    }

}