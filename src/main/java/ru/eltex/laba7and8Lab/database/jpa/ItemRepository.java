package ru.eltex.laba7and8Lab.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eltex.laba7and8Lab.database.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findOneById(int id);
}
