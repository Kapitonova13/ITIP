import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegEx3 {
    public static void main(String[] args) {
        //Замена всех ссылок на гиперссылки        

        String input = "Пример текста с ссылкой: wwhw.apple.ru.hf и еще одной ссылкой: google.com, также https://www.com.ty.jkd";

        replacingLinksWithHyperlinks(input);   
    }

    public static void replacingLinksWithHyperlinks(String input) {
        String regex = "(?<!https?://)\\b\\S+\\.\\S+\\b"; 
        try {
            Pattern p = Pattern.compile(regex);                               
            Matcher m = p.matcher(input);
            StringBuilder result = new StringBuilder();
            while (m.find()) {
                String url = m.group();
                if (!url.matches("https?://.*")) {
                    url = "https://" + url;
                }
                m.appendReplacement(result, url);
            }
            m.appendTail(result);
            System.out.println(result);
        }
        catch (PatternSyntaxException e) {
            System.err.println("Ошибка регулярного выражения: " + e.getMessage());
  
        }
    }

}
