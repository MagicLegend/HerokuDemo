package com.magiclegend.herokudemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cookie {
    @Id
    @GeneratedValue
    long id;

    boolean crumbly;
    String topping;

    public Cookie(boolean crumbly, String topping) {
        this.crumbly = crumbly;
        this.topping = topping;
    }
}
