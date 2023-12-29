import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public class RegEx5 {
    public static void main(String[] args) {
    // Поиск всех слов, начинающихся с заданной буквы
  
        String text = "cat cancel,Cron ;;Cran c";
        String letter = "n";

        text = text.toLowerCase();
        letter = letter.toLowerCase();
        
        // Проверка ввода
        if (text.isEmpty() || letter.isEmpty()) {
            System.out.println("Ошибка: текст или буква не были введены");
            return;
        }

        // Регулярное выражение для поиска слов,  с заданной буквы
        String regex = "\\b(\\w*)" + letter + "\\b";

        findWords(text, regex);
    }

    public static void findWords(String text, String regex) {
        try{
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с заданной буквы:");

        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в выражении: " + e.getMessage());
        }
    }
    
}
