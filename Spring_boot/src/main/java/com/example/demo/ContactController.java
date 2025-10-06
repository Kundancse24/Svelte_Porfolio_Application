package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "http://localhost:5182")
public class ContactController {

    // Absolute path for CSV file
    private static final String CSV_FILE_PATH = "C:\\Users\\ASUS\\Downloads\\demo\\contacts.csv";

    @PostMapping("/api/contacts/contact")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
        // Print data to console for real-time debugging
        System.out.println("Received contact:");
        System.out.println("Fullname: " + contact.getFullname());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Message: " + contact.getMessage());

        try {
            boolean fileExists = Files.exists(Paths.get(CSV_FILE_PATH));

            try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
                // Write CSV header if file doesn't exist
                if (!fileExists) {
                    writer.println("Fullname,Email,Message");
                }
                // Escape quotes and wrap in double quotes
                writer.printf("\"%s\",\"%s\",\"%s\"%n",
                        contact.getFullname(),
                        contact.getEmail(),
                        contact.getMessage().replace("\"", "\"\""));
            }

            return ResponseEntity.ok("Contact saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving contact");
        }
    }
}
