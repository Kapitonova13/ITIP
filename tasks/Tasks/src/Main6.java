import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class Main6 {
     public static void main(String[] args)  { 
         System.out.println("-1-");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
         System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
         System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
         System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
         System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
         System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        
         System.out.println("-2-");
//
         System.out.println(collect("intercontinentalisationalism", 6));
         System.out.println(collect("strengths", 3));
         System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));

         System.out.println("-3-");

         System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
         System.out.println(nicoCipher("andiloveherso", "tesha"));
         System.out.println(nicoCipher("mubashirhassan", "crazy"));
         System.out.println(nicoCipher("edabitisamazing", "matt") );
         System.out.println(nicoCipher("iloveher", "612345"));

         System.out.println("-4-");

         System.out.println(twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15}, 46));
         System.out.println(twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45));
         System.out.println(twoProduct(new int[] {1,  2, -1,  4,  5,  6,  10, 7}, 20));
         System.out.println(twoProduct(new int[] {1, 2, 3, 4, 5,  6, 7, 8, 9, 105}, 10));
         System.out.println(twoProduct(new int[] {100, 12, 4, 1, 2}, 15));

         System.out.println("-5-");

         System.out.println(isExact(6));
         System.out.println(isExact(24));
         System.out.println(isExact(125));
         System.out.println(isExact(720));
         System.out.println(isExact(1024));
         System.out.println(isExact(40320));

         System.out.println("-6-");

         System.out.println(fractions("0.(6)"));
         System.out.println(fractions("1.(1)"));
         System.out.println(fractions("3.(142857)"));
         System.out.println(fractions("0.19(2367)"));
         System.out.println(fractions("0.1097(3)"));

         System.out.println("-7-");

         System.out.println(pilish_string("33314444") );
         System.out.println(pilish_string("TOP") );
         System.out.println(pilish_string("X"));
         System.out.println(pilish_string(""));

         System.out.println("-8-");

         System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
         System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

         System.out.println("-9-");

         System.out.println(isValid("aabbcd"));
         System.out.println(isValid("aabbccddeefghi"));
         System.out.println(isValid("abcdefghhgfedecba"));
         System.out.println(isValid("abcc"));

         System.out.println("-10-");

         System.out.println(findLCS("abcd", "bd"));
         System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    // // -1-
     public static String hiddenAnagram(String x, String y) {
//         x=x.toLowerCase().replace(" ", "");
//         y=y.toLowerCase().replace(" ", "");

         // убираем пробелы и знаки препинания, приводим к нижнему регистру
         String cleanStr = x.replaceAll("[^a-zA-Z]", "").toLowerCase();
         String cleanAnagram = y.replaceAll("[^a-zA-Z]", "").toLowerCase();

         char[] anagramArray = cleanAnagram.toCharArray();
         Arrays.sort(anagramArray);

         for (int i = 0; i <= cleanStr.length() - cleanAnagram.length(); i++) {
             String subStr = cleanStr.substring(i, i + cleanAnagram.length());
             char[] subArray = subStr.toCharArray();
             Arrays.sort(subArray);

             if (Arrays.equals(anagramArray, subArray)) {
                 return subStr;
             }
         }


         return "notfound";
     }



    // -2-

    public static List<String> collect(String stringIn, int n) {
        List<String> result = new ArrayList<>();
        recourseColect(stringIn, n, result);
        Collections.sort(result);
        return result;
    }
    static void recourseColect(String stringIn, int n, List<String> result) {
        if (stringIn.length() < n) { return; }
        String slice = stringIn.substring(0, n);
        result.add(slice);
        recourseColect(stringIn.substring(n), n, result);
    }


    // // -3-
     public static String nicoCipher(String message, String key) {
         char[] chars = key.toCharArray();
         Arrays.sort(chars);
         //отсортированная строка с ключом
         String sortedKey = new String(chars);
         int[] intKey = new int[key.length()];
         for (int i = 0; i < intKey.length; i++) {
             //заполняем массив индексами в том порядке, в котором они расположены в отсортированной строке
             // т.е. если первая  буква а, то берём индекс этой буквы в ключе
             intKey[i] = key.indexOf(sortedKey.charAt(i));
         }
         //округление вверх
         int length = (int) Math.ceil((double) message.length() / (double) intKey.length);
//         System.out.println(length);
         // кол-во строк в массиве равно длине слова поделённой на длину ключа
         //кол-во столбцов длине ключа
         char[][] letters = new char[length][intKey.length];
         for (int i = 0; i < length; i++) {
             for (int j = 0; j < intKey.length; j++) {
                 if (i * intKey.length + j >= message.length()) {
                     letters[i][j] = ' ';
                 } else {
                     letters[i][j] = message.charAt(i * intKey.length + j);
                 }
             }
         }
         StringBuilder result = new StringBuilder();
         for (int i = 0; i < length; i++) {
             for (int j = 0; j < intKey.length; j++) {
                 result.append(letters[i][intKey[j]]);
             }
         }
         return result.toString();
     }


    // // -4-
    public static String twoProduct(int[] nums, int n) {
        ArrayList<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (n%num==0) {
            int c = n/num;

            if (map.containsKey(c)) {
                int[] pair = {c, num};
                pairs.add(pair);
                break;
            }
            map.put(num, c);
        }
        }
        if (pairs.isEmpty()) {
            int[] a = new int[0];
            return Arrays.toString(a);

        }
        int[] result;
        result=pairs.get(0);

        return Arrays.toString(result);
    }

    // // -5-
     public static String isExact(int n) {
         return Arrays.toString(isExactHelper(n, 1));
     }
    private static int[] isExactHelper(int n, int m) {
        int factorial = 1;
        for (int i = 1; i <= m; i++) {
            factorial *= i;
        }

        if (factorial == n) {
            return new int[]{n, m};
        } else if (factorial > n) {
            return new int[]{};
        } else {
            return isExactHelper(n, m + 1);
        }
    }

    // // -6-
     public static String fractions(String number) {
         //всё, что до "("
         double finite = Double.parseDouble(number.substring(0, number.indexOf('(')));
         //сохранение повторяющейся части (в скобках)
         String infinteString = number.substring(number.indexOf('(') + 1, number.lastIndexOf(')'));

         //от . до "("
         String a = number.substring(number.indexOf('.') + 1, number.lastIndexOf('('));
         int a1 = 0;

         if (a.isEmpty()) {}
         else {
             a1 += Integer.parseInt(a);
         }

         //до .
         String e = number.substring(0, number.indexOf('.'));
         int e1 = Integer.parseInt(e);

         //строка после .
         String b = Integer.toString(a1) + infinteString;
         int b1 = Integer.parseInt(b);

         int chilslit = (int) (b1-a1);
         //знаменатель формируется таким образом, что кол-во цифр в () - кол-во 9, а кол-во цифр от . до "(" - кол-во 0
         String c = "";
         for (int i=0; i<infinteString.length(); i++) {
             c+="9";
         }
         for (int i=0; i<a.length(); i++) {
             c+="0";
         }
         //знаменатель
         int d = Integer.parseInt(c);
         //если есть целая часть
         int k = e1*d+chilslit;

         int gcd = gcd(k, d);
         k /= gcd;
         d /= gcd;
         return k + "/" + d;
     }
    private static int gcd(int a, int b) {
         if (b==0) {
             return a;
         }
         return gcd(b, a%b);
       }
    // // -7-
     public static String pilish_string(String s) {
         if (s.isEmpty()) {
             return "";
         }
         int[] pi = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
         StringBuilder result = new StringBuilder();
         int last = 0;
         for (int digit : pi) {
             if (last + digit > s.length()) {
                 //последняя буква повторяется нужное кол-во раз
                 result.append(s, last, s.length()).append(s.substring(s.length() - 1).repeat(last + digit - s.length()));
             } else {
                 //добавляем кол-во символов строки, соответ-ее цифре из числа пи
                 result.append(s, last, last + digit).append(" ");
             }
             last += digit;
             if (last >= s.length()) {
                 break;
             }
         }
         return result.toString();
     }

    // // -8-

    public static String generateNonconsecutive(String txt) {
        Pattern pattern = Pattern.compile("(\\(*-?\\d+(\\.\\d+)?\\)* [+\\-*/] )*\\(*-?\\d+(\\.\\d+)?\\)*");
        if (!pattern.matcher(txt).matches()) {
            return "Invalid statement";
        }

        txt = txt.replaceAll("\\(", "( ");
        txt = txt.replaceAll("\\)", " )");
        //  расположение операторов, как они идут в строке
        LinkedList<String> queue = new LinkedList<>();
        // правильное расположение операторов
        Stack<String> stack = new Stack<>();
        for (String elem : txt.split(" ")) {
            try {
                //происходит попытка преобразования элемента в числовой тип данных типа double
                // если  удалось, то элемент считается числом и  добавляется в queue
                double num = Double.parseDouble(elem);
                queue.add(Double.toString(num));
            } catch (NumberFormatException ignore) {
                //если stack пустой или содержит только "(",
                // то оператор или скобка добавляются в stack
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(elem);
                    // если текущий оператор "*" или "/", а опеератор на вершине стека "+" или "-",
                    // то оператор добавляется в stack
                } else if ((elem.equals("*") || elem.equals("/")) && (stack.peek().equals("+") || stack.peek().equals("-"))) {
                    stack.push(elem);
                } else if (elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                    while (true) {
                        String top = stack.peek();
                        if (top.equals("(") || ((elem.equals("*") || elem.equals("/")) && (top.equals("+") || top.equals("-")))) {
                            break;
                        }
                        queue.add(stack.pop());
                    }
                    stack.push(elem);
                } else if (elem.equals("(")) {
                    stack.push(elem);
                } else if (elem.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    System.out.println(elem);
                    return "Invalid Statement";
                }
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        // стек для сохранения результатов вычислений
        Stack<Double> result = new Stack<>();
        while (!queue.isEmpty()) {
            String elem = queue.removeFirst();
            try {
                // если элемент может быть преобразован в число, он преобразуется в тип double и добавляется в result
                double num = Double.parseDouble(elem);
                result.push(num);
            } catch (NumberFormatException e) {
                switch (elem) {
                    case "+":
                        result.push(result.pop() + result.pop());
                        break;
                    case "-":
                        result.push(-result.pop() + result.pop());
                        break;
                    case "*":
                        result.push(result.pop() * result.pop());
                        break;
                    case "/":
                        double num1 = result.pop();
                        double num2 = result.pop();
                        if (num1 == 0) {
                            return "ZeroDivision";
                        }
                        result.push(num2 / num1);
                }
            }
        }
        return Double.toString(result.pop());
    }

    // // -9-
    public static String isValid(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArr = str.toCharArray();

        for (char ch : charArr) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        // возвращается набор всех значений
        var values = map.values();
//        System.out.println(values);
        // макс значение
        int max = Collections.max(values);
        //кол-во таких макс значений
        int maxCount = 0;
        for (int v: values) {
            if (v == max) {
                maxCount+=1;
            }
        }
        // кол-во значений макс-1 для проверки условия
        int maxCountMinus = 0;
        for (int v: values) {
            if (v == max-1) {
                maxCountMinus+=1;
            }
        }
        //если все буквы в одинаковоом кол-ве
        if (maxCount == values.size()) {
            return "YES";
        //если макс значение только одно и количество оставшихся значений равно макс-1(тк можно удалить лишь один символ)
        } else if (maxCount == 1 && maxCountMinus == values.size() - 1) {
            return "YES";
        }
            return "NO";
     }
//

    // // -10-
     public static String findLCS(String s1, String s2) {
         String[][] solution = new String[s1.length() + 1][s2.length() + 1];
         //заполнение 1 столбца
         for (int i = 0; i < s1.length()+1; i++) {
             solution[i][0] = "";
         }
         //заполнение первойй строки
         for (int i = 0; i < s2.length()+1; i++) {
             solution[0][i] = "";
         }
         for (int i = 1; i < s1.length()+1; i++) {
             char a = s1.charAt(i - 1);
             for (int j = 1; j < s2.length()+1; j++) {
                 char b = s2.charAt(j - 1);
                 if (a == b) {
                     solution[i][j] = solution[i - 1][j - 1] + a;
                 } else {
                     solution[i][j] = solution[i - 1][j].length() > solution[i][j - 1].length() ? solution[i - 1][j] : solution[i][j - 1];
                 }
             }
         }
         return solution[s1.length()][s2.length()];

     }

    
}
