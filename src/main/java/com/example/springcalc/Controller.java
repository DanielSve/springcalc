package com.example.springcalc;

import com.example.springcalc.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("")
    private Person getPerson() {
        return new Person((long) 1,"Daniel");
    }


}
