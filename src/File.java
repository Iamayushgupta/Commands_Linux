import java.time.LocalDateTime;

public class File implements Item {
    private String name;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public File(String name) {
        this.name = name;
        this.content = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
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
