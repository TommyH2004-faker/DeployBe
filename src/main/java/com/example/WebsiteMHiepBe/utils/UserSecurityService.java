package com.example.WebsiteMHiepBe.utils;


import com.example.WebsiteMHiepBe.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface UserSecurityService extends UserDetailsService {
    public User findByUsername(String username);
}
