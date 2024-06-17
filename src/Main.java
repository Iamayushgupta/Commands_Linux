import repository.ItemRepository;
import service.FileSystemService;
public class Main {
    public static void main(String[] args) {
        ItemRepository itemRepository = new ItemRepository();
        FileSystemService fileSystemService = new FileSystemService(itemRepository);

        // Example usage
        fileSystemService.mkdir("documents");
        fileSystemService.cd("documents");
        fileSystemService.touch("file1.txt");
        fileSystemService.ls();
        fileSystemService.cd("..");
        fileSystemService.ls();
    }
}
