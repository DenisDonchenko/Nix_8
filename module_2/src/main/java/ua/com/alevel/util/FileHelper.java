package ua.com.alevel.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    public static void createFolders(String... pathToFolder) {
        for (int i = 0; i < pathToFolder.length; i++) {
            Path path = Paths.get(pathToFolder[i]);
            try {
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writerTextToFile(String pathToFile,String text) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(pathToFile))) {
            writter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String... pathToFile) {
        for (int i = 0; i < pathToFile.length; i++) {
            File file = new File(pathToFile[i]);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearFiles(String... files) {
        for (int i = 0; i < files.length; i++) {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(files[i]);
            } catch (FileNotFoundException e) {
                return;
            }
            writer.print("");
            writer.close();
        }
    }
}
