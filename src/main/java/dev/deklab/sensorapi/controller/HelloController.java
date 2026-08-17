package dev.deklab.sensorapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/greet/{name}")
    public String greetWithName(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping("/greet")
    public String greetWithNameAndExcitement(@RequestParam String name,
            @RequestParam(defaultValue = "false") boolean excited) {
        if (excited) {
            return "Hello, " + name + "!";
        } else {
            return "Hello, " + name;

        }
    }

}
