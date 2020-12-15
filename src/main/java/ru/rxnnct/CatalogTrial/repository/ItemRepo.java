package ru.rxnnct.CatalogTrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rxnnct.CatalogTrial.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
