package ru.rxnnct.CatalogTrial.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import ru.rxnnct.CatalogTrial.model.Item;
import ru.rxnnct.CatalogTrial.repository.ItemRepo;
import ru.rxnnct.CatalogTrial.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("api/json/items")
public class ItemJsonRestController {
    private final ItemRepo itemRepo;
    private final ApplicationContext context;

    @Autowired
    public ItemJsonRestController(ItemRepo itemRepo, ApplicationContext context) {
        this.itemRepo = itemRepo;
        this.context = context;
    }

    //Gets all catalog entities
    @GetMapping
    public List<Item> getAll() {
        return itemRepo.findAll();
    }

    //Gets one directory entity
    @GetMapping("{id}")
    public Item getOne(@PathVariable("id") Item item) {
        return item;
    }

    //Finds all entities by name by a substring.
    @GetMapping("/find-by-name")
    @ResponseBody
    public List<Item> findByName(@RequestParam(required = false) String name) {
        return context.getBean(ItemService.class).findByName(name);
    }

    //Creates entity
    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemRepo.save(item);
    }

    //Updates entity
    @PutMapping("{id}")
    public Item update(
            @PathVariable("id") Item itemFromDb,
            @RequestBody Item item
    ) {
        BeanUtils.copyProperties(item, itemFromDb, "id", "name");
        return itemRepo.save(itemFromDb);
    }

    //Deletes entity
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Item item) {
        itemRepo.delete(item);
    }

}
