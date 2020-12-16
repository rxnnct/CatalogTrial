package ru.rxnnct.CatalogTrial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rxnnct.CatalogTrial.model.Item;
import ru.rxnnct.CatalogTrial.repository.ItemRepo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    EntityManager entityManager;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> findByName(String name){
        Query query = entityManager.createQuery("from Item where Name like '%" + name + "%'");
        return (List<Item>) query.getResultList();
    }
}
