import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    try {
    System.out.print("Введите целое число: ");

    String input = scanner.nextLine();

    if (isInteger(input)) {
    } else {
        validateInput();
    }

    System.out.println("Введенное число: " + input);

    } catch (CustomInputMismatchException e) {
        logException(e);
        System.out.println("Ошибка: " + e.getMessage());
  
}}
public static void validateInput() throws CustomInputMismatchException {
        throw new CustomInputMismatchException("Ввод не является числом!");
}

public static void logException(CustomInputMismatchException e) {

    try (PrintWriter writer = new PrintWriter(new FileWriter("aa.txt", true))) {   

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        writer.println("Дата и время: " + formattedDateTime);
        writer.println("Ошибка: " + e.getMessage());
        writer.println("-------------------------");

    } catch (IOException ex) {
        System.out.println("I/O ошибка:" + ex.getMessage());
 
    }
    }

public static boolean isInteger(String input) {
    try {
        Integer.parseInt(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }

}

   
