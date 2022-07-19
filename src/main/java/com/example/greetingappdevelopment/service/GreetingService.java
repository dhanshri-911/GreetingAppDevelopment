package com.example.greetingappdevelopment.service;

import com.example.greetingappdevelopment.model.GreetingData;
import com.example.greetingappdevelopment.repository.RepositoryGreeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    RepositoryGreeting repositoryGreeting;
    public String getmessage() {
        return "Hello World";
    }
    public String sayHelloByName(String firstName, String lastName) {
        return "Hello "+firstName+" "+lastName;
    }

    public GreetingData addData(GreetingData greetingData) {
         repositoryGreeting.save(greetingData);
         return greetingData;
    }
}
