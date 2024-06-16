package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Directory extends AbstractItem {
    private Map<String, Item> contents;
    private Directory parent;

    public Directory(String name, Directory parent) {
        super(name);
        this.contents = new HashMap<>();
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public void add(Item item) {
        contents.put(item.getName(), item);
        this.updatedAt = LocalDateTime.now();
    }

    public void remove(String name) {
        if (contents.remove(name) != null) {
            this.updatedAt = LocalDateTime.now();
        }
    }

    public Item get(String name) {
        return contents.get(name);
    }

    public Set<String> listContents() {
        return contents.keySet();
    }
}
