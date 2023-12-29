import java.util.regex.PatternSyntaxException;
public class RegEx2 {
    public static void main(String[] args) {
    //Проверка корректности ввода пароля
     String password = "dnf8sjdnHH";
     if (password.isEmpty()) {
        System.out.println("Ошибка: пароль не был введен");
        return;
    }
        
    validatePassword(password);
   
    }

    public static void validatePassword(String password) {

        // Регулярное выражение для проверки пароля
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        try{

        // Проверка пароля
        //если строка не соответствует регулярному выражеению
        if (!password.matches(passwordRegex)) {
            System.out.println("Пароль не соответствует требованиям:\n" +
                    "- Должен состоять из латинских букв и цифр,\n" +
                    "- Длина должна быть от 8 до 16 символов,\n" +
                    "- Должен содержать хотя бы одну заглавную букву и одну цифру.");
      
        } else {
            System.out.println("Пароль корректен.");
        }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в выражении: " + e.getMessage());

        }
    }
}

