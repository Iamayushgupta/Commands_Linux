package repository;

import model.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemRepository {
    private Map<String, Item> storage = new HashMap<>();

    public void save(Item item) {
        storage.put(item.getName(), item);
    }

    public Item findByName(String name) {
        return storage.get(name);
    }

    public void deleteByName(String name) {
        storage.remove(name);
    }

    public Map<String, Item> findAll() {
        return storage;
    }
}

