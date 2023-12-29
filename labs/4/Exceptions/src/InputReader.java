import java.io.*;

public class InputReader {
    public static void main(String[] args) {

        String sourceFileName = "/Users/anyak/lab ITP/source.txt";

        String destinationFileName =  "/Users/anyak/lab ITP/destination.txt";;

        try (FileReader fileReader = new FileReader(sourceFileName);
             FileWriter fileWriter = new FileWriter(destinationFileName)) {
            fileWriter.close();

            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }
            System.out.println("Файл успешно скопирован!");


        } catch (IOException e) {
            System.out.println("I/O ошибка: " + e.getMessage());
        }
    }
}

