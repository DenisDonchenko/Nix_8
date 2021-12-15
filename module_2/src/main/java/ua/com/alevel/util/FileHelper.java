package ua.com.alevel.util;

import java.io.File;
import java.io.IOException;
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
}
