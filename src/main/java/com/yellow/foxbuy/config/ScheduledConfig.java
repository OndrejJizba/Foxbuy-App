package com.yellow.foxbuy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.time.LocalTime;

@Configuration
@EnableScheduling
public class ScheduledConfig {
    private static final String INVOICE_FOLDER_PATH = "resources/generated-PDF";

    @Scheduled(cron = "0 00 18 * * *")
    public void deleteInvoices() {
        File folder = new File(INVOICE_FOLDER_PATH);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".pdf"));

        if (files == null || files.length == 0) {
            System.out.println("No PDF files found in the directory. " + LocalTime.now());
            return;
        }

        for (File file : files) {
            if (file.delete()) {
                System.out.println("Deleted file: " + file.getName());
            } else {
                System.err.println("Failed to delete file: " + file.getName());
            }
        }
    }
}




