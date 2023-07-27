package Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void main(String[] args) {
        String sourceDirectory = "./Homework5/Files";
        String backupDirectory = "./backup";

        try {
            File backupDir = new File(backupDirectory);
            backupDir.mkdir();

            File[] files = new File(sourceDirectory).listFiles();

            if (files != null) {
                for (File file: files) {
                    if(file.isFile()) {
                        File backupFile = new File(backupDirectory + "/" + file.getName());
                        Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        System.out.println(file.getName() + "has been backed up to " + backupFile.getPath());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
