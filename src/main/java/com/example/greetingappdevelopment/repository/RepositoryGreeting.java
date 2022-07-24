package com.example.greetingappdevelopment.repository;

import com.example.greetingappdevelopment.model.GreetingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryGreeting extends JpaRepository<GreetingData,Integer> {
}
