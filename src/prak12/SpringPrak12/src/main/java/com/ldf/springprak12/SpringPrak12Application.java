package com.ldf.springprak12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SpringPrak12Application {

    @Value("${sourceFileName}")
    private String sourceFileName;

    @Value("${hashedFileName}")
    private String hashedFileName;

    public SpringPrak12Application(@Value("${sourceFileName}") String sourceFileName,
                                  @Value("${hashedFileName}") String hashedFileName) {
        this.sourceFileName = sourceFileName;
        this.hashedFileName = hashedFileName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringPrak12Application.class, args);
    }

    @PostConstruct
    public void initialize() throws IOException, NoSuchAlgorithmException {
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            // Если исходный файл отсутствует, создаем новый файл и записываем в него строку "null"
            try (PrintWriter writer = new PrintWriter(sourceFile)) {
                writer.write("null");
            }
        }

        // Читаем данные из исходного файла
        byte[] fileBytes = readFile(sourceFile);

        // Хешируем данные
        byte[] hashedBytes = hashData(fileBytes);

        // Записываем захешированные данные в файл
        writeFile(hashedFileName, hashedBytes);
    }

    @PreDestroy
    public void cleanup() {
        File sourceFile = new File(sourceFileName);
        if (sourceFile.exists()) {
            boolean deleted = sourceFile.delete();
            if (!deleted) {
                System.err.println("Failed to delete source file: " + sourceFile.getAbsolutePath());
            }
        }
    }

    private byte[] readFile(File file) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            int bytesRead = inputStream.read(bytes);
            if (bytesRead == -1) {
                System.err.println("Failed to read from file: " + file.getAbsolutePath());
                return null;
            }
            return bytes;
        }
    }

    private void writeFile(String fileName, byte[] data) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data);
        }
    }

    private byte[] hashData(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(data);
    }
}
