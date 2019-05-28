package com.magiclegend.herokudemo.repositories;

import com.magiclegend.herokudemo.models.Cookie;
import org.springframework.data.repository.CrudRepository;

public interface CookieRepository extends CrudRepository<Cookie, Long> {
}
