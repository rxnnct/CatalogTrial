package ru.rxnnct.CatalogTrial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rxnnct.CatalogTrial.model.Item;
import ru.rxnnct.CatalogTrial.repository.ItemRepo;

@Component
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item findByName(String name){
        return itemRepo.findAll().get(0); //todo: remove
    }
}
