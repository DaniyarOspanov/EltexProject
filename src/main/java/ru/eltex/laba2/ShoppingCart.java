package ru.eltex.laba2;
import ru.eltex.laba1.Drink;

import java.io.Serializable;
import java.util.*;

public class ShoppingCart <T extends Drink> implements Serializable {

    private UUID CartID;
    private List<T> cart;
    private Set<UUID> uuids;

    public ShoppingCart() {
        this.CartID = UUID.randomUUID();
        this.cart = new LinkedList<>();
        this.uuids = new HashSet<>();
    }

    public boolean add(T product) {
        uuids.add(product.getUUID());
        return this.cart.add(product);
    }

    void delete(T product) {
        this.cart.remove(product);
    }

    public void show() {
        for(T val: cart) {
            val.read();
        }
    }

    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }

    public void showShort() {
        for(T val: cart) {
            System.out.println(val.Name+"("+val.price+") - "+ val.country);
        }

    }
}