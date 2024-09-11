import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    public static void main(String[] args) {
        String secretFile = ".password.txt";
        String secretData = "a password"; //i know, i'm so creative
        String secretFolder = ".secretFolder";
        String regularFile = ".secretFolder/data.dat";
        String regularData = "top-secret data";

        /*// 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secretFile))) {
            bufferedWriter.write(secretData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File folder = new File (secretFolder);
        folder.mkdir();
        File regular = new File (regularFile);
        try {
            regular.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(regularFile))) {
            bufferedWriter.write(regularData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } */

        /*
        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } */

        /* 
        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } */
    }

    private static void printFileSize (String fileName) {
        File file = new File(fileName);
        System.out.println (file.length());
    }

    private static void printTotalFileSize (String... fileName) { //String... representats a variable number of inputs/parameters
        System.out.println ("Total size of all files: ...TBD... bytes");
    }
}