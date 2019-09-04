package ru.eltex.laba7and8Lab.database.dao;

import org.springframework.stereotype.Repository;
import ru.eltex.laba7and8Lab.database.entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class DrinkDaoImpl implements DrinkDao {
    private final EntityManager em;

    public DrinkDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Item> getAll() {
        Query query = em.createQuery("select entity from Drink entity");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Item Item) {
        em.persist(Item);
    }
}
