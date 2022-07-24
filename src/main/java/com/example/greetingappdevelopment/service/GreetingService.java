package com.example.greetingappdevelopment.service;

import com.example.greetingappdevelopment.model.GreetingData;
import com.example.greetingappdevelopment.repository.RepositoryGreeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    @Autowired
    RepositoryGreeting repositoryGreeting;

    public Optional<GreetingData> sayHelloById(int id) {
        return repositoryGreeting.findById(id);
    }

    public List<GreetingData> showAll() {
        return repositoryGreeting.findAll();
    }


    public String getmessage() {
        return "Hello World";
    }

    public String sayHelloByName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    public GreetingData addData(GreetingData greetingData) {
        repositoryGreeting.save(greetingData);
        return greetingData;
    }

    public GreetingData save(GreetingData greetingData) {
        return repositoryGreeting.save(greetingData);
    }

    public String delete(int id) {
        Optional<GreetingData> newUser = repositoryGreeting.findById(id);
        if (newUser.isPresent()) {
            repositoryGreeting.delete(newUser.get());
            return "Deleted record with id number: " + id;
        } else {
            return "Record not Found";
        }
    }

    public GreetingData edit(int id, GreetingData greetingData) {

        GreetingData getUser = repositoryGreeting.getReferenceById(id);
        getUser.setFirstName(greetingData.getFirstName());
        getUser.setLastName(greetingData.getLastName());
        GreetingData updateUser;
        updateUser = repositoryGreeting.save(getUser);
        return updateUser;
    }

}
