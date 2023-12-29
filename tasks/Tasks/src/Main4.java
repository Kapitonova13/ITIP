import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.Collections;

public class Main4 {
    public static void main(String[] args)  {
        System.out.println("-1-");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi")); 
        // System.out.println(nonRepeatable("aabb"));
        
        System.out.println("-2-");

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        // System.out.println(generateBrackets(4));

        System.out.println("-3-");

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(binarySystem(2));

        System.out.println("-4-");

        System.out.println(alphabeticRow("ababab"));
        System.out.println(alphabeticRow("aaaaa"));
        System.out.println(alphabeticRow("klmabzyxw"));
        // System.out.println(alphabeticRow("cbadcba"));

        System.out.println("-5-");

        System.out.println(t("aaabbcdd"));
        System.out.println(t("vvvvaajaaaaa") );

        System.out.println("-6-");

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        // System.out.println(convertToNum("one thousand"));

        System.out.println("-7-");

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("-8-");

        System.out.println(shortestWay(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
            }));
        System.out.println(shortestWay(new int[][] {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9},
            }));

        System.out.println("-9-");

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("-10-");

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    // -1-
    public static String nonRepeatable(String x) {
        x = x.toLowerCase();

        if (x.isEmpty()) {
            return "";
        }
        
        char firstChar = x.charAt(0);
        //содержит со 2 символа и до конца
        String restOfString = x.substring(1);
        
        if (restOfString.contains(String.valueOf(firstChar))) {
        
            // Если символ повторяется, удаляем его из оставшейся части строки
            restOfString = restOfString.replace(String.valueOf(firstChar), "");
        }
        
        // Рекурсивно вызываем функцию для оставшейся части строки
        String result = nonRepeatable(restOfString);
        
        // Возвращаем текущий символ + результат рекурсивного вызова
        return firstChar + result;
    

    }

    // // -2-
    public static List<String> generateBrackets(int x) {
        List<String> result = new ArrayList<>();
        generate("", x, x, result);
        return result;
    }

    private static void generate(String current, int open, int close, List<String> result) {
        if (open == 0 & close == 0) {
            result.add(current);
            return;
        }

        if (open > 0) {
            generate(current + "(", open - 1, close, result);
        }

        if (close > open) {
            generate(current + ")", open, close - 1, result);
        }
    }

    // // -3-
    public static List<String> binarySystem(int x) {
        List<String> result = new ArrayList<>();
        generateBinaryCombinations(result, "", x);
        return result;
    }

    private static void generateBinaryCombinations(List<String> result, String current, int x) {
        if (x == 0) {
            result.add(current);
        } else {
            if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
                generateBinaryCombinations(result, current + '0', x - 1);
                
            }
            generateBinaryCombinations(result, current + '1', x - 1);
        }
    }

    // -4-
    public static String alphabeticRow(String x) {
        x = x.toLowerCase();
        String max = "";
        String c = String.valueOf(x.charAt(0));
        //true, если первый символ следует за вторым символом в алфавитном порядке или если второй символ следует за первым 
        boolean abba = (x.charAt(0) + 1 == x.charAt(1) || x.charAt(0)-1 == x.charAt(1));
        //true, если первый символ следует за вторым символом в алфавитном порядке
        boolean ab = x.charAt(0) + 1 == x.charAt(1);
        for (int i = 1; i < x.length() - 1; i++) {
            //Если true, то текущий символ добавляется к строке c т.е. символы продолжаются в последовательности в алфавитном порядке
            if (abba) {
                c += x.charAt(i);
            }
            if (abba & i == x.length() - 2 & ab == (x.charAt(i) + 1 == x.charAt(i + 1))) {
                c += x.charAt(i + 1);
                if (c.length() > max.length()) {
                    max = c;
                }
            }
            if (abba & ab == (x.charAt(i) + 1 == x.charAt(i + 1))) {
            } else {
                if (c.length() > max.length()) {
                    max = c;
                }
                c = String.valueOf(x.charAt(i));
            }
            abba = (x.charAt(i) + 1 == x.charAt(i + 1) || x.charAt(i) == x.charAt(i + 1) + 1);
            ab = x.charAt(i) + 1 == x.charAt(i + 1);
        }
        return max;
    }




//     // -5-
    public static String t(String x) {
        x = x.toLowerCase();
        class A {
            private char ch;
            private int n;
            public A(char ch, int n) {
                this.ch = ch;
                this.n = n;
            }
            public char getChar() { 
                return ch; 
            }
            public int getInt() { 
                return n; 
            }
        }

        List<A> list = new ArrayList<>();
        char currentChar = x.charAt(0);
        int k = 1;

        for (int i = 1; i < x.length(); i++) {
            if (currentChar == x.charAt(i)) {
                k++;
            } else {
                list.add(new A(currentChar, k));
                k = 1;
                currentChar = x.charAt(i);
            }
        }
        list.add(new A(currentChar, k));
        Collections.sort(list, Comparator.comparingInt(A::getInt));
        String result = "";
        for (A charint : list) {
            result = result + charint.getChar();
            result = result + charint.getInt();
        }
        return  result;
    }


    

    // -6-
    public static int convertToNum(String x) {
        x = x.toLowerCase();

   
        // Создаем словарь для соответствий слов и чисел
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);
        numberMap.put("eleven", 11);
        numberMap.put("twelve", 12);
        numberMap.put("thirteen", 13);
        numberMap.put("fourteen", 14);
        numberMap.put("fifteen", 15);
        numberMap.put("sixteen", 16);
        numberMap.put("seventeen", 17);
        numberMap.put("eighteen", 18);
        numberMap.put("nineteen", 19);
        numberMap.put("twenty", 20);
        numberMap.put("thirty", 30);
        numberMap.put("forty", 40);
        numberMap.put("fifty", 50);
        numberMap.put("sixty", 60);
        numberMap.put("seventy", 70);
        numberMap.put("eighty", 80);
        numberMap.put("ninety", 90);
        numberMap.put("hundred", 100);

        String[] words = x.split(" ");
        int result = 0;
        int k = 0;

        for (String word : words) {
            if (numberMap.containsKey(word)) {
                int number = numberMap.get(word);
                if (number == 100) {
                    k *= number;
                } else {
                    k += number;
                }
                
            } else {
                k = 0;
            }
        }

        result += k;

        return result;
    }


    

    // // -7-
    public static String uniqueSubstring(String x) {
        int maxLength = 0;
        String longestSubstring = "";
        
        for (int i = 0; i < x.length(); i++) {
            for (int j = i + 1; j <= x.length(); j++) {
                String substring = x.substring(i, j);
                if (isUnique(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                    longestSubstring = substring;
                }
            }
        }
        
        return longestSubstring;
    }
    
    private static boolean isUnique(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // -8-
    public static int shortestWay(int[][] x) {
        int n = x.length;
        int[][] dp = new int[n][n];
        dp[0][0] = x[0][0];

        // Заполняем первую строку
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + x[0][i];
        }

        // Заполняем первый столбец
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + x[i][0];
        }

        // Заполняем оставшиеся ячейки
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + x[i][j];
            }
        }

        return dp[n - 1][n - 1];
    }
    

    // // -9-
    public static String numericOrder(String x) {

        String[] words = x.split(" ");

        //  массив для упорядоченных слов
        String[] orderedWords = new String[words.length];

        for (String word : words) {
            //  индекс  вставки слова в упорядоченный массив
            int index = 0;
            String a = "";

            //  по символам в слове
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                // Если символ - цифра, определяется индекс вставки
                if (Character.isDigit(c)) {
                    
                    index = Character.getNumericValue(c) - 1;
                    String s = String.valueOf(c);
                    a = a + word.replace(s, "");
                }
            }
            
            // Вставляем слово в упорядоченный массив
            orderedWords[index] = a;
        }

        // Собираем упорядоченные слова в новую строку

        StringBuilder result = new StringBuilder();
        for (String orderedWord : orderedWords) {
            result.append(orderedWord).append(" ");
        }

        // Удаляем последний пробел и возвращаем результат
        return result.toString().trim();
    
    }

    //-10-
    public static int switchNums(int x, int y) {
    
        // Преобразуем оба числа в массивы цифр
        char[] num1Digits = String.valueOf(x).toCharArray();
        char[] num2Digits = String.valueOf(y).toCharArray();

        // Сортируем цифры первого числа по убыванию
        Arrays.sort(num1Digits);
        reverseArray(num1Digits);

        // return Arrays.toString(num1Digits);
        
        for (int i = 0; i < num2Digits.length; i++) {
            for (int j = 0; j < num1Digits.length; j++) {
                if (num2Digits[i] < num1Digits[j]) {
                    num2Digits[i] = num1Digits[j];
                    num1Digits[j] = 0;

            }
        }}

        // Преобразуем массив цифр в число и возвращаем результат
        return Integer.parseInt(new String(num2Digits));
    }

    // Метод для разворота массива
    public static void reverseArray(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
