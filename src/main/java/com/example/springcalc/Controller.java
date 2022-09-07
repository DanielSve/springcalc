package com.example.springcalc;

import com.example.springcalc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("")
    private String startPage() {
        return "<h1>Welcome! Type /users to view users</h1>";
    }

    @GetMapping("/users")
    private List<User> getUsers() {
        return List.of(new User(1L, "Per"), new User(2L, "Hugo"), new User(3L, "Pernilla"));
    }
}
