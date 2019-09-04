package ru.eltex.laba7and8Lab.database.dao;

import ru.eltex.laba7and8Lab.database.entities.Item;

import java.util.List;

public interface DrinkDao {
    /**
     * @return Полученее всех todo's
     */
    List<Item> getAll();

    /**
     * Сохранение entity todo в БД
     */
    void save(Item todoEntity);
}
