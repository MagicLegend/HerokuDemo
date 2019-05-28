package com.magiclegend.herokudemo;

import com.magiclegend.herokudemo.models.Cookie;
import com.magiclegend.herokudemo.repositories.CookieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Controller
@RestController
public class TestController {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(TestController.class.getName());

    @Value("${security.oauth2.client.client-id:client-id}")
    private String clientId;

    private final CookieRepository cookieRepository;

    public TestController(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @GetMapping("/test")
    String test(@RequestParam String input) {
        return "Hi " + input;
    }

    @GetMapping("/variable")
    String variable() {
        return "clientId: " + clientId;
    }

    @PostMapping("/database")
    String newCookie() {
        Cookie cookie = new Cookie(true, "Chocolate");
        cookieRepository.save(cookie);
        return String.format("Stored cookie. Is it crumbly? %b. And it is topped with: %s", cookie.isCrumbly(), cookie.getTopping());
    }

    @GetMapping("/database")
    List<Cookie> getCookie() {
        List<Cookie> bestCookies = new ArrayList<>();
        Iterable<Cookie> cookies = cookieRepository.findAll();
        cookies.forEach(cookie -> {
            LOGGER.log(Level.INFO, "I found a cookie with id {0}, which is topped with {1}! But is it crumbly? {2}", new Object[]{cookie.getId(), cookie.getTopping(), cookie.isCrumbly()});
            bestCookies.add(cookie);
        });
        return bestCookies;
    }
}
