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
    @Autowired
    private ApplicationContext context;

    @Autowired
    public ItemJsonRestController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public List<Item> getAll() {
        return itemRepo.findAll();
    }

    @GetMapping("{id}")
    public Item getOne(@PathVariable("id") Item item) {
        return item;
    }

    @GetMapping("/find-by-name")
    @ResponseBody
    public List<Item> findByName(@RequestParam(required = false) String name) {
        return context.getBean(ItemService.class).findByName(name);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemRepo.save(item);
    }

    @PutMapping("{id}")
    public Item update(
            @PathVariable("id") Item itemFromDb,
            @RequestBody Item item
    ) {
        BeanUtils.copyProperties(item, itemFromDb, "id", "name");
        return itemRepo.save(itemFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Item item) {
        itemRepo.delete(item);
    }

}
