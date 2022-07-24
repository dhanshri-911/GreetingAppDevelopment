package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.model.GreetingData;
import com.example.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getmessage")
    public String getByService() {
        String message = greetingService.getmessage();
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
    @PostMapping("/add")
    public GreetingData getdata(@RequestBody GreetingData greetingData) {
        GreetingData greetingData1 = greetingService.addData(greetingData);
        return greetingData1;
    }

    @GetMapping("/get/{id}")
    public Optional<GreetingData> sayHelloById(@PathVariable int id) {
        Optional<GreetingData> response = greetingService.sayHelloById(id);
        return response;
    }

    @GetMapping("/getall")
    public List<GreetingData> showAll() {
        List<GreetingData> response = greetingService.showAll();
        return response;
    }

    @PutMapping("/edit")
    public GreetingData edit(@RequestBody GreetingData greetingData) {
        return greetingService.save(greetingData);
    }

    @PutMapping("/edit/{id}")
    //  public User edit(@RequestBody User user) {
    public GreetingData edit(@RequestBody GreetingData greetingData, @PathVariable int id) {
        GreetingData response;
        response = greetingService.edit(id, greetingData);
        return response;
        //     return springRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        String response;
        response = greetingService.delete(id);
        return response;
    }
}
