package com.example.yunishop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public String main() {
        return "main";
    }
}
