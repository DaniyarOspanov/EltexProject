package ru.eltex.laba7and8Lab.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eltex.laba7and8Lab.database.entities.Item;
import ru.eltex.laba7and8Lab.database.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    Item findOneById(int id);
}
