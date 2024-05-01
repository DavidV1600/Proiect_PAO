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
            // Obține timestamp-ul curent
            LocalDateTime timestamp = LocalDateTime.now();
            // Formatează timestamp-ul într-un format specific (de exemplu, "yyyy-MM-dd HH:mm:ss")
            String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            // Scrie înregistrarea în fișierul CSV
            writer.println(actionName + "," + formattedTimestamp);
        } catch (IOException e) {
            System.out.println("A apărut o eroare la scrierea în fișierul CSV: " + e.getMessage());
        }
    }
}
