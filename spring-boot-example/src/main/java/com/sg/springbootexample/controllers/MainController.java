/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.springbootexample.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DZ
 */
@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }

    @GetMapping("/test")
    public Map<String, String> test() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("firstName", "Dmitriy");
        myMap.put("lastName", "Zelenskiy");
        myMap.put("middleName", "A");
        return myMap;
    }
}
