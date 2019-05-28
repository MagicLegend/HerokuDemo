package com.magiclegend.herokudemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {
    @Value("${security.oauth2.client.client-id:client-id}")
    private String clientId;

    @GetMapping("/test")
    String test(@RequestParam String input) {
        return "Hi " + input;
    }

    @GetMapping("/variable")
    String variable() {
        return "clientId: " + clientId;
    }
}
