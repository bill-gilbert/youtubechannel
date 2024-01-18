package com.laurentiuspilca.springsecurityc2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        var u = authentication.getAuthorities();
        u.forEach(a->log.info(a.getAuthority()));
        return "Hello!";
    }
}
