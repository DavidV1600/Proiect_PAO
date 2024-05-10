package Proiect_PAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvWriterService {
    private static final String CSV_FILE_PATH = "actions.csv";

    public static void writeCsv(String actionName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            LocalDateTime timestamp = LocalDateTime.now();
            String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println(actionName + "," + formattedTimestamp);
        } catch (IOException e) {
            System.out.println("An error has occurred while trying to write to file: " + e.getMessage());
        }
    }
}
