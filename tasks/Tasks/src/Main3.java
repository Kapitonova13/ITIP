import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main3 {
    public static void main(String[] args)  {
        System.out.println("-1-");

        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println("-2-");

        System.out.println(stringTransform("helloo"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("-3-");

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("-4-");

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        System.out.println("-5-");

        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));
        // System.out.println(countRoots(new int[] {1, -10, 10}));

        System.out.println("-6-");

        System.out.println(salesData(new String[][] {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        }));

        System.out.println(salesData(new String[][] {
            {"Fridge", "Shop2", "Shop3"},
            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Laptop", "Shop3", "Shop4"},
            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        }));

        System.out.println("-7-");

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        System.out.println("-8-");

        System.out.println(waveForm(new int[] {4, -1, 1, 0}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("-9-");

        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println(commonVovel("Aabb"));

        System.out.println("-10-");

        System.out.println(dataScience(new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        }));

        System.out.println(dataScience(new int[][] {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        }));

    }
    // -1- ???? soglasnie na *
    //гласные на *
    public static String replaceVovels(String x) {
        // return x.toLowerCase().replace("a", "*").replace("e", "*").replace("i", "*").replace("o", "*").replace("u", "*").replace("y", "*");
        StringBuilder r = new StringBuilder();
        for(int i = 0; i<x.length(); i++) {
            char c = x.charAt(i);
            if ("aeiouAEIOU".indexOf(c) == -1) {
                r.append(c);
            } else {
                r.append('*');
            }
        }
        return r.toString();
    } 

    // -2-
    //две идущие подряд буквы по шаблону «Double*».
    public static String stringTransform(String x) {
        x = x.toLowerCase();
        char[] x1 = x.toCharArray();
        char[] x2 = x.toCharArray();
        String y = "";

        for (int i = 1; i < x1.length; i++) {
            if (x1[i-1] == x1[i]) {
                char ch = x1[i-1];
                String str = Character.toString(ch).toUpperCase();

                StringBuilder sb = new StringBuilder();
                sb.append(x1);
                sb.deleteCharAt(i);
                x1 = sb.toString().toCharArray();
                y = y + "Double" + str;
            } else {
                y = y + x1[i-1];
                
            }
        }
        // System.out.println(x2);
        if (x2[x2.length-1] != x2[x2.length-2]){
            y = y + x1[x1.length-1];}
        return y;

    } 

    // -3- // lakoni4na9 proverka
    //ребенку разобраться с игрушкой на развитие 
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {

        int[] aa = {a,b,c};
        Arrays.sort(aa);
        int[] bb = {w,h};
        Arrays.sort(bb);
        if (bb[1]>=aa[1] && bb[0]>=aa[0]) { 
            return true;
        }
        return false;

    } 

    // -4-    lakoni4noe yslovie
    // сумма квадратов его цифр имеет ту же четность, что и само число.
    public static boolean numCheck(int x) {
        String numberString = Integer.toString(x);
        char[] charArray = numberString.toCharArray();

        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int a = Character.getNumericValue(charArray[i]);
            int aa = a*a;
            intArray[i] = aa;
        }
        // return Arrays.toString(intArray);
        int sum = Arrays.stream(intArray).sum();
       
        if (x % 2 == sum % 2 ) {
            return true;
        }
        return false;
        
    }

    

    // -5-
    // celae korny kvadrat yrav
    public static int countRoots(int[] x) {
        double d = x[1]*x[1] - 4 * x[0] * x[2];
        int k = 0;
        if (d>0) {
            double x1 = (-x[1] + Math.sqrt(d))/(2*x[0]);
            double x2 = (-x[1] - Math.sqrt(d))/(2*x[0]);
            if (x1 % 1 == 0) {
                k=k+1;
            }
            if (x2 % 1 == 0) {
                k=k+1;
            }

        } else if (d == 0) {
            double x1 = (-x[1])/(2*x[0]);
            if (x1 % 1 ==0) {
                k=k+1;
        }
        } else {
            k=0;
        }
        return k;
    } 

    // -6-  
    public static List<String> salesData(String[][] x) {
        // return Arrays.deepToString(x);
        //  карта для отслеживания (в каких магазинах продан каждый продукт)
        Map<String, List<String>> productSalesMap = new HashMap<>();
        int max = 0;
        // Проходим по массиву и заполняем карту
        for (int i = 0; i < x.length; i++) {
            String product = x[i][0];
            if (max<x[i].length) {
                max = x[i].length;
            }
            for (int j = 1; j < x[i].length; j++) {
                String shop = x[i][j];
                List<String> shops = productSalesMap.getOrDefault(product, new ArrayList<>());
                shops.add(shop);
                productSalesMap.put(product, shops);
            }
        }
        //  товары, которые были проданы в каждом магазине
        List<String> commonlySoldProducts = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : productSalesMap.entrySet()) {
            if (entry.getValue().size() == max - 1) {
                commonlySoldProducts.add(entry.getKey());
            }
        }

        return commonlySoldProducts;     
     }

    // -7-
    //разбить заданное предложение на слова чтобы каждое слово 
    //начиналось с последней буквы предыдущего слова.
    public static boolean validSplit(String x) {
        String[] words = x.split(" ");
        
        if (words.length < 2) {
            return false;
        }
        for (int i = 1; i < words.length; i++) {
            String x1 = words[i - 1];
            String x2 = words[i];
            //  последняя буква предыдущего и первая буква текущего слова
            char lastChar = x1.charAt(x1.length() - 1);
            char firstChar = x2.charAt(0);
            

            if (Character.toLowerCase(lastChar) != Character.toLowerCase(firstChar)) {
                return false;
            }
        }
        return true;
    } 

    // -8-
    //volna
    public static boolean waveForm(int[] x) {
        int k = 0;
        for (int i = 2; i<x.length; i++) {
            if (x[i-2] > x[i-1] & x[i-1] < x[i]) {
                k = k+1;
            }else if (x[i-2] < x[i-1] & x[i-1] > x[i]) {
                k = k + 1;
            } else {
                k=0;
            }
        }
        if (k>0) {
            return true;
        } else {
            return false;
        }
    } 

    // -9-
    //наиболее часто встречающуюся гласную в предложении.
    public static char commonVovel(String x) {
        x=x.toLowerCase();
        int[] vowels = new int[26];
        // Подсчитываем количество каждой гласной в предложении
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        vowels[c - 'a']++;
        }
        }
        // return Arrays.toString(vowels)
        int max = 0;
        char commonVowel = ' ';

        // Находим гласную с наибольшим количеством встреч
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] > max) {
            max = vowels[i];
            commonVowel = (char) (i + 'a');
        }
        }
        return commonVowel;   
    } 

    // -10-
    //принимает n целочисленных массивов длины n, а затем изменяет каждый n-ый элемент 
    //n-го массива на среднее арифметическое элементов n-го столбца остальных массивов.
    public static String dataScience(int[][] x) {
    int n = x.length; 
    for (int i = 0; i < x[0].length; i++) {
        int sum = 0;  //2ой индекс
        // Вычисляем сумму элементов в текуще
        for (int j = 0; j < x.length; j++) { //1ый индекс
            sum = sum + x[j][i];
        }
        sum = sum - x[i][i];
        float average = sum % (n-1);
        int av;
        if (average >= (n/2)) {
            av = (sum / (n-1)) + 1;
            
        } else {
            av = (sum / (n-1));
        }

        // Заменить 1ый элемент 1ого массива и  тд
        x[i][i] = av;
    }
    return Arrays.deepToString(x);
}
    }
    
