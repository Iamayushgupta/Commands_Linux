package model;

import java.time.LocalDateTime;

public interface Item {
    String getName();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
