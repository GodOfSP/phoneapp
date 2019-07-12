package com.ybveg.ls.phoneapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    private String[] test(){
        return new String[]{"asd","asdasfdsf"};
    }
}
