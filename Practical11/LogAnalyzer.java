
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        
        Files.write(Paths.get("log1.txt"), Arrays.asList(
            "Application started",
            "Error in login",
            "User logged in"
        ));

        Files.write(Paths.get("log2.txt"), Arrays.asList(
            "Error in database",
            "Application closed"
        ));

        Path folder = Paths.get(".");
        int totalLines = 0;
        int keywordLines = 0;
        String keyword = "Error";

        // Read all text files in the folder
        try (DirectoryStream<Path> files =
                 Files.newDirectoryStream(folder, "*.txt")) {

            for (Path file : files) {
                int fileLines = 0;

                // Read the file line by line
                for (String line : Files.readAllLines(file)) {
                    fileLines++;

                    if (line.contains(keyword)) {
                        keywordLines++;
                    }
                }

                totalLines += fileLines;

                
                System.out.println("File: " + file.getFileName());
                System.out.println("Lines: " + fileLines);
                System.out.println("Size: " + Files.size(file) + " bytes");
                System.out.println();
            }
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing '" + keyword
                           + "': " + keywordLines);
    }
}
