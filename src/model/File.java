package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class File extends AbstractItem {
    @Setter
    private String content;

    public File(String name) {
        super(name);
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }
}
