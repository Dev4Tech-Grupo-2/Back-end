package com.dev4tech.group2.littlegeniuses.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootEntryPoint {

    @GetMapping
    public String rootEntryPoint() {
        return "Welcome to little geniuses API!";
    }

}
