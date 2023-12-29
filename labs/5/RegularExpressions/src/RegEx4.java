
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public class RegEx4 {
    public static void main(String[] args) {
        // Проверка корректности ввода IP-адреса
    
        String ipAddress = "88.88.88.88";

        if (ipAddress.isEmpty()) {
            System.out.println("Ошибка: текст не был введен");
            return;
        }

        isValidIPAddress(ipAddress);
       
    }

    private static void isValidIPAddress(String ipAddress) {
      
        String IP = "^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.{3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$";

        try{
        Pattern pattern = Pattern.compile(IP);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println("Введен корректный IP-адрес.");
        } else {
            System.out.println("Ошибка! Введите корректный IP-адрес. \nIP-адрес должен состоять из 4 чисел," + 
            "разделенных точками, и каждое число должно быть в диапазоне от 0 до 255.");            
        }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в выражении: " + e.getMessage());
            
        }        
    }
}

