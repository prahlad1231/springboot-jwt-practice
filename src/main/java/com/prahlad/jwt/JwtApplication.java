package com.prahlad.jwt;

import com.prahlad.jwt.entity.User;
import com.prahlad.jwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "admin", "admin", "admin@gmail.com"),
                new User(102, "user1", "password1", "user1@gmail.com"),
                new User(103, "user2", "password2", "user2@gmail.com"),
                new User(104, "user3", "password3", "user3@gmail.com")
        ).collect(Collectors.toList());
        userRepo.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

}
