package com.learning.learningmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EasterEggController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hidden-feature/{number}")
    public String getEasterEgg(@PathVariable int number) {
        
        

       
        ResponseEntity<String> response = restTemplate.getForEntity("http://numbersapi.com/" + number, String.class);

       
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return "Failed to fetch random fact from Numbers API";
        }
    }
}
