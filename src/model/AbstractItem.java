package model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public abstract class AbstractItem implements Item {
    protected String name;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public AbstractItem(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
