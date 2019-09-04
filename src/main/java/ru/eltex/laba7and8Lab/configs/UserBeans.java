package ru.eltex.laba7and8Lab.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.eltex.laba1.Coffee;
import ru.eltex.laba1.Drink;
import ru.eltex.laba1.Tea;
import ru.eltex.laba2.Credentials;
import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;
import ru.eltex.laba2.ShoppingCart;

@Configuration
public class UserBeans {

    @Bean("Orders")
    public Orders<Order> getOrders(@Qualifier("FirstCart") ShoppingCart<Drink> cart1,
                                   @Qualifier("SecondCart") ShoppingCart<Drink> cart2,
                                   @Qualifier("User") Credentials user) throws InterruptedException {
        Orders<Order> orders = new Orders<>();
        orders.offer(cart1, user);
//        Thread.sleep(1000);
        orders.offer(cart2, user);
        return orders;
    }

    @Bean("User")
    public Credentials getCredentials() {
        return new Credentials("Оспанов", "Данияр", "Дюсюгбаевич", "ospanov@gmail.com");
    }

    @Bean("FirstCart")
    public ShoppingCart<Drink> getShoppingCart1() {
        ShoppingCart<Drink> cart1 = new ShoppingCart<>();
        cart1.add(new Tea("Assam", "JFK", "Spain", 78, 15, "box"));
        cart1.add(new Tea("Lipton", "KDV", "England", 195, 15, "bunch"));
        cart1.add(new Tea("Greenfield", "Nestlea", "Germany", 150, 17, "package"));
        return cart1;
    }

    @Bean("SecondCart")
    public ShoppingCart<Drink> getShoppingCart2() {
        ShoppingCart<Drink> cart2 = new ShoppingCart<>();
        cart2.add(new Coffee("bushido", "Bushido", "Brazil", 600, 10, "Arabic"));
        cart2.add(new Tea("Klimbo", "Nestlea", "Australia", 900, 13, "Робуста"));
        return cart2;
    }
}
