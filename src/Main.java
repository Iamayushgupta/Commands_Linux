public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        // Creating directories
        fs.mkdir("dir1");
        fs.mkdir("dir2");

        // Change to dir1 and create subdirectories and files
        fs.cd("dir1");
        fs.mkdir("subdir1");
        fs.mkdir("subdir2");
        fs.touch("file1.txt");
        fs.touch("file2.txt");

        // Add content to files in dir1
        File file1 = (File) fs.getCurrentDir().get("file1.txt");
        file1.setContent("Hello, this is file1 in dir1.");
        File file2 = (File) fs.getCurrentDir().get("file2.txt");
        file2.setContent("Hello, this is file2 in dir1.");

        // List contents of dir1
        System.out.println("\ndir1 directory contents:");
        fs.ls();

        // Change to subdir1 and create a file
        fs.cd("subdir1");
        fs.touch("file3.txt");
        File file3 = (File) fs.getCurrentDir().get("file3.txt");
        file3.setContent("Hello, this is file3 in subdir1.");

        // List contents of subdir1
        System.out.println("\nsubdir1 directory contents:");
        fs.ls();

        // Move back to root directory and then to dir2
        fs.cd("..");
        fs.cd("..");
        fs.cd("dir2");

        // Create subdirectories and files in dir2
        fs.mkdir("subdir3");
        fs.touch("file4.txt");
        File file4 = (File) fs.getCurrentDir().get("file4.txt");
        file4.setContent("Hello, this is file4 in dir2.");

        // List contents of dir2
        System.out.println("\ndir2 directory contents:");
        fs.ls();

        // Demonstrate moving a file from dir1 to dir2
        fs.cd("..");
        fs.move("dir1/file1.txt", "dir2");
        fs.cd("dir2");
        System.out.println("\ndir2 directory contents after moving file1.txt from dir1:");
        fs.ls();

        // List contents of root directory
        fs.cd("..");
        System.out.println("\nRoot directory contents:");
        fs.ls();
    }
}
