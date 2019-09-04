package ru.eltex.laba7and8Lab.controllers;

import org.springframework.web.bind.annotation.*;
import ru.eltex.laba7and8Lab.database.entities.Item;
import ru.eltex.laba7and8Lab.database.entities.Order;
import ru.eltex.laba7and8Lab.services.OrderService;

import java.util.List;


@RequestMapping("orders")
@RestController
public class UserController {

    private final OrderService orderService;

    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    public List<Order> readAll() {
        return orderService.readAll();
    }

    @GetMapping("/{id}")
    public Order readById( @PathVariable int id) {
        return orderService.findById(id);
    }

    @PostMapping
    public void addToCard(@RequestBody Order order) {
        orderService.save(order);
    }

    @DeleteMapping
    public void delById(long orderId) {
         orderService.delById(orderId);
    }
}