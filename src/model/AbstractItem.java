package model;

import java.time.LocalDateTime;

public abstract class AbstractItem implements Item {
    protected String name;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public AbstractItem(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return name;
    }
}
