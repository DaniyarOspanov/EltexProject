package ru.eltex.laba7and8Lab.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.eltex.laba7and8Lab.database.entities.Order;
import ru.eltex.laba7and8Lab.database.jpa.OrdersRepository;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class);

    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @PostConstruct
    private void init() {
        List<Order> all = ordersRepository.findAll();
        logger.debug(all);
    }

    public List<Order> readAll() {
        return ordersRepository.findAll();
    }

    public Order findById(long id) {
        return ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public void delById(long id) {
        ordersRepository.deleteById(id);
    }

    public void save(Order order) {
        ordersRepository.save(order);
    }
}
