import java.util.regex.*;
import java.util.Scanner;
public class RegEx {
public static void main(String[] args) {
    // Поиск всех чисел в тексте

    String text = "ejnhcdh7 hnde7 777di 9/ 8.8 h-7+9";

    if (text.isEmpty()) {
            System.out.println("Ошибка: текст не был введен");
            return;
        }
    
    findAndPrintNumbers(text);
    
}

    public static void findAndPrintNumbers(String text) {
        // Регулярное выражение для поиска чисел
        String numberRegex = "-?\\d*\\.?\\d+";
        try{
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(text);

        // Ищем числа и выводим на экран
        while (matcher.find()) {
            String number = matcher.group();
            System.out.println("Найдено число: " + number);
}
        } catch(PatternSyntaxException e){
            System.err.println("Ошибка в выражении: " + e.getMessage());
        }
}
}

