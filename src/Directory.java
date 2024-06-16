import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Directory implements Item {
    private String name;
    private Map<String, Item> contents;  // Can hold both files and directories
    private Directory parent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.contents = new HashMap<>();
        this.parent = parent;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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

    @Override
    public String toString() {
        return name;
    }
}
