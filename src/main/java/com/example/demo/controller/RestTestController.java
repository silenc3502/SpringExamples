package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController는 어떤 데이터든 json으로 처리
@RestController
public class RestTestController {
    @RequestMapping("/test")
    public String test() {
        return "Spring Test Check";
    }
}
