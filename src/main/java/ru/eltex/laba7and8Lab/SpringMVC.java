package ru.eltex.laba7and8Lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Drink;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

@SpringBootApplication
public class SpringMVC {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ApplicationContext enter = SpringApplication.run(SpringMVC.class, args);
    }

}
