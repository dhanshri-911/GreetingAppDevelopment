package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.model.GreetingData;
import com.example.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    //UC1
    @GetMapping("/getMap")
    public String getMessage() {
        return "Hello  World";
    }

    @GetMapping("/getByParam")
    public String getByParam(@RequestParam String name) {
        return "Hello" + name;
    }

    @GetMapping("/getPath/{name}")
    public String getPath(@PathVariable String name) {
        return "Hello" + name;
    }

    //UC2
    @GetMapping("/getbyservice")
    public String getbyservice(){
        String message=greetingService.getmessage();
        return message;
    }

    //UC3
    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (lastName == null) lastName = "";
        else if (firstName == null) firstName = "";
        else if (firstName == null && lastName == null) {
            firstName = "";
            lastName = "";
        }
        return greetingService.sayHelloByName(firstName, lastName);
    }
    //UC4
    @PostMapping("/getData")
    public GreetingData getdata(@RequestBody GreetingData greetingData){
     GreetingData greetingData1 = greetingService.addData(greetingData);
     return greetingData1;
    }
}