package service;

import model.Directory;
import model.File;
import model.Item;
import repository.ItemRepository;


public class FileSystemService {
    private ItemRepository itemRepository;
    private Directory root;
    private Directory currentDir;

    public FileSystemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.root = new Directory("root", null);
        this.currentDir = root;
        this.itemRepository.save(root);
    }

    public Directory getCurrentDir() {
        return currentDir;
    }

    public void move(String src, String dst) {
        Item srcItem = currentDir.get(src);
        if (srcItem != null) {
            currentDir.remove(src);
            Item dstItem = currentDir.get(dst);
            if (dstItem instanceof Directory) {
                ((Directory) dstItem).add(srcItem);
            } else {
                System.out.println("Error: Destination " + dst + " is not a directory.");
            }
        } else {
            System.out.println("Error: Source " + src + " does not exist.");
        }
    }

    public void ls() {
        for (String name : currentDir.listContents()) {
            Item item = currentDir.get(name);
            if (item instanceof File) {
                File file = (File) item;
                System.out.println("File: " + file.getName() + ", Created: " + file.getCreatedAt() + ", Modified: " + file.getUpdatedAt());
            } else if (item instanceof Directory) {
                Directory dir = (Directory) item;
                System.out.println("Directory: " + dir.getName() + ", Created: " + dir.getCreatedAt() + ", Modified: " + dir.getUpdatedAt());
            }
        }
    }

    public void touch(String name) {
        if (currentDir.get(name) == null) {
            File newFile = new File(name);
            currentDir.add(newFile);
            itemRepository.save(newFile);
        } else {
            System.out.println("Error: File " + name + " already exists.");
        }
    }

    public void cd(String name) {
        if (name.equals("..")) {
            if (currentDir.getParent() != null) {
                currentDir = currentDir.getParent();
            } else {
                System.out.println("Error: Already at the root directory.");
            }
        } else {
            Item newDir = currentDir.get(name);
            if (newDir instanceof Directory) {
                currentDir = (Directory) newDir;
            } else {
                System.out.println("Error: Directory " + name + " does not exist.");
            }
        }
    }

    public void mkdir(String name) {
        if (currentDir.get(name) == null) {
            Directory newDir = new Directory(name, currentDir);
            currentDir.add(newDir);
            itemRepository.save(newDir);
        } else {
            System.out.println("Error: Directory " + name + " already exists.");
        }
    }
}

