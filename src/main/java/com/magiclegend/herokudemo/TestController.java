package com.magiclegend.herokudemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {
    @GetMapping("/test")
    String test(@RequestParam String input) {
        return "Hi " + input;
    }
}
