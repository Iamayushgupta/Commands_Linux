package model;

import java.time.LocalDateTime;

public class File extends AbstractItem {
    private String content;

    public File(String name) {
        super(name);
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }
}

