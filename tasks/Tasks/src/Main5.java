import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Date;

public class Main5 {
        public static void main(String[] args)  {
        System.out.println("-1-");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); 
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        
        System.out.println("-2-");

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println("-3-");

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
    

        System.out.println("-4-");

        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        // System.out.println(totalPoints(new String[] {"ara"}, "caar"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant") );
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println("-5-");

        System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[] {10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));
        // System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));

        System.out.println("-6-");

        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));

        System.out.println("-7-");

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println(caesarCipher("encode", "x", 4));

        System.out.println("-8-");

        System.out.println(setSetup(5, 3)); 
        System.out.println(setSetup(7, 3)); 

        System.out.println("-9-");

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("-10-");

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(130));
       
        


    }

    // -1-
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Создаем карту для хранения соответствий символов
        // одной строки символам другой строки
        HashMap<Character, Character> map = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            

            // содержится ли ключ ch1, если содержится, то проверяется 
            // значение под этим ключом, которое должно соответствовать ch2 
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                // Если символ ch1 встречается впервые, добавляется в map
                // вместе с соответствующим символом ch2
                map.put(ch1, ch2);
            }
        }
        
        return true;
    }
   
    

    // -2-
    public static String spiderVsFly(String spider, String fly) {
        int[] spiderCoords = new int[2];
        spiderCoords[0] = spider.charAt(0) - 'A';
        spiderCoords[1] = spider.charAt(1) - '0';

        int[] flyCoords = new int[2];
        flyCoords[0] = fly.charAt(0) - 'A';
        flyCoords[1] = fly.charAt(1) - '0';
        //A-0 B-1 C-2 D-3 E-4 F-5 G-6 H-7
        if (Math.abs(spiderCoords[0] - flyCoords[0]) == 4) {
            StringBuilder result = new StringBuilder();
            for (int i = spiderCoords[1]; i > 0; i--) {
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append("A0-");
            for (int i = 1; i < flyCoords[1]; i++) {
                result.append((char) ('A' + flyCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append(fly);
            return result.toString();
        } else {
            StringBuilder result = new StringBuilder();
            // паук снижается до уровня мухи
            // уменьшается координата паука по вертикали
            for (; spiderCoords[1] > flyCoords[1]; spiderCoords[1]--) {
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + spiderCoords[1]));
                result.append("-");
            }
            //  находится ли паук в центре поля
            for (; spiderCoords[1] >= 0; spiderCoords[1]--) {
                if (spiderCoords[1] == 0) {
                    result.append("A0-");
                    spiderCoords[1] = 1;
                    break;
                }
                //координата паука по вертикали меньше или равна координаты мухи 
                if (Math.abs(spiderCoords[1] - flyCoords[1]) + lengthDuga(spiderCoords[1]) * (Math.abs(spiderCoords[0] - flyCoords[0]) % 4) < (spiderCoords[1] + flyCoords[1])) {
                    // увеличивает или уменьшает горизонтальную координату паука  в направлении мухи
                    for (int j = spiderCoords[0]; j != flyCoords[0]; j += (int) Math.signum(flyCoords[0] - spiderCoords[0])) {
                        result.append((char) ('A' + j));
                        result.append((char) ('0' + spiderCoords[1]));
                        result.append("-");
                    }
                    break;
                }
                //
                result.append((char) ('A' + spiderCoords[0]));
                result.append((char) ('0' + spiderCoords[1]));
                result.append("-");
            }
            //координата паука по вертикали меньше координаты мухи
            for (int i = spiderCoords[1]; i < flyCoords[1]; i++) {
                result.append((char) ('A' + flyCoords[0]));
                result.append((char) ('0' + i));
                result.append("-");
            }
            result.append(fly);
            return result.toString();
        }
   
    }
    private static double lengthDuga(int r) {
        // длина дуги
        return r * Math.sqrt(2 - Math.sqrt(2));
    }

    // -3-

    public static int digitsCount(long x) {
        if (x / 10 == 0) {
            return 1;
        }
        return digitsCount(x / 10) + 1;
    }
 
  

    // -4-
    public static int totalPoints(String[] words, String mainW) {

    
        mainW = sortedStr(mainW);
        int score = 0;
        for (String word : words) {
            int thisScore = 0;
            word = sortedStr(word);
            int i = 0;
            // каждая буква главного слова сравнивается с буквами составных слов
            for (char letter : mainW.toCharArray()) {
                if (letter == word.charAt(i)) {
                    thisScore = thisScore+1;
                    i++;
                }
            }
            //thisScore равен количеству букв - (thisScore-2) для подсчета очков
            // еcли букв меньще 3 -> 0
            if (i == word.length()) {
                score = score + Math.max(0, thisScore - 2);
                if (mainW.length() == word.length()) {
                    score=score+50;

                }
                
            }
        }
        return score;
        }
        private static String sortedStr(String a) {
            char[] chars = a.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }




    // -5-
        
      public static String sumsUp(int[] nums) {
        ArrayList<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int c = 8 - num;
            if (map.containsKey(c)) {
                int[] pair = {num, c};
                Arrays.sort(pair);
                pairs.add(pair);
            }
            map.put(num, c);
        }
    
        
        int[][] result = new int[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i);
        }
        
        return Arrays.deepToString(result);
    }
  


    // -6-
    public static String takeDownAverage(String[] classmatesGrades) {
        int[] m = new int[classmatesGrades.length];

       // заполняем массив m
        for(int i=0; i<classmatesGrades.length; i++) {
            String a = classmatesGrades[i];
            // убрать %
            a=a.replace("%", "");
            // строку в число
            int b=Integer.parseInt(a);
            // массив цифр
            m[i] = b;
        }
        
        //сумма цифр в массиве
        double summ = Arrays.stream(m).sum();
        // среднее значение
        double sr = summ/m.length;
        // снижение среднего балла на 5
        double minus = sr-5;
        // формула для подсчета нужного числа 
        double otvet = (minus*(m.length+1))-summ;
    
        //целая часть
        int otvet2 = (int) otvet;
        
        String str = String.valueOf(otvet2);
        return str+"%";

    }

    // -7-
    public static String caesarCipher(String operation, String message, int shift) {
       
        StringBuilder result = new StringBuilder();

        // Обработка сообщений только в верхнем регистре
        message = message.toUpperCase();

        if ("encode".equals(operation)) {
            for (char ch : message.toCharArray()) {
                // является ли буквой
                if (Character.isLetter(ch)) {
                    char encode = (char) ((ch - 'A' + shift) % 26 + 'A');
                    result.append(encode);
                } else {
                    result.append(ch);
                }
            }
        } else if ("decode".equals(operation)) {
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char decode = (char) ((ch - 'A' + shift) % 26 + 'A');
                    result.append(decode);
                } else {
                    result.append(ch);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid operation. Use 'ENCODE' or 'DECODE'.");
        }

        return result.toString();
    }
   
    

    // -8-
    public static int setSetup(int n, int k) {
        if (n < k) {
            throw new IllegalArgumentException("n >= k");
        }

        // n! / n!
        if (k == 0) {
            return 1;
        }

        // n! / (n - k)!
        return factorial(n) / factorial(n - k);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    
   
    }
    

    // // -9-
    
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        HashMap<String, TimeZone> timeZones = new HashMap<>();
        timeZones.put("Los Angeles", SimpleTimeZone.getTimeZone("GMT-8"));
        timeZones.put("New York", SimpleTimeZone.getTimeZone("GMT-5"));
        timeZones.put("Caracas", SimpleTimeZone.getTimeZone("GMT-4:30"));
        timeZones.put("Buenos Aires", SimpleTimeZone.getTimeZone("GMT-3"));
        timeZones.put("London", SimpleTimeZone.getTimeZone("GMT"));
        timeZones.put("Rome", SimpleTimeZone.getTimeZone("GMT+1"));
        timeZones.put("Moscow", SimpleTimeZone.getTimeZone("GMT+3"));
        timeZones.put("Tehran", SimpleTimeZone.getTimeZone("GMT+3:30"));
        timeZones.put("New Delhi", SimpleTimeZone.getTimeZone("GMT+5:30"));
        timeZones.put("Beijing", SimpleTimeZone.getTimeZone("GMT+8"));
        timeZones.put("Canberra", SimpleTimeZone.getTimeZone("GMT+10"));
        //создаются два форматтера времени с использованием SimpleDateFormat
        // firstFormat используется для разбора входящей строки времени в объект  с учетом временной зоны города cityA
        //  secondFormat используется для форматирования  в строку с учетом временной зоны города cityB.
        SimpleDateFormat firstFormat = new SimpleDateFormat("MMMM d, yyyy H:m", Locale.US);
        firstFormat.setTimeZone(timeZones.get(cityA));
        SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);
        secondFormat.setTimeZone(timeZones.get(cityB));
        // попытка разбора входящей строки timestamp с использованием форматтера firstFormat
        // если разбор проходит успешно, полученная дата форматируется в строку с использованием форматтера secondFormat
        try {
            return secondFormat.format(firstFormat.parse(timestamp));
        } catch (ParseException ignored) {
            return "error";
        }}
  
    // -10-
 
    public static boolean isNew(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int number = n;
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        
        Collections.sort(digits);
        number = 0;
        int i = 0;
        while (!digits.isEmpty()){
            //условие, чтобы не было ведущих нулей
            if (number == 0 && digits.get(i) == 0){
                i++;
            }else {
                number = number * 10 + digits.remove(i);
                i = 0;
            }
        }
        return number == n;
    }
}

    

