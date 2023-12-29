// import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args)  {
        System.out.println("-1-");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println("-2-");

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        System.out.println("-3-");

        int [] a = new int[] {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(a));
        int [] b = new int[] {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(b));

        System.out.println("-4-");

        System.out.println(equalToAvg(new int[] {1, 2, 3, 4, 5}));
        System.out.println(equalToAvg (new int[] {1, 2, 3, 4, 6}));

        System.out.println("-5-");

        System.out.println(indexMult(new int[] {1, 2, 3}));
        System.out.println(indexMult(new int[] {3, 3, -2, 408, 3, 31}));

        System.out.println("-6-");

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println("-7-");

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println("-8-");

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println("-9-");

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(botHelper("help"));

        System.out.println("-10-");

        System.out.println(isAnagram("Listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
        
    }

    // -1-
    public static boolean duplicateChars(String x) {
        x = x.toLowerCase();

        char[] m = x.toCharArray();
        int k = 0;
        for (int i = 0; i < x.length(); i++) {
            for (int j = i+1; j < x.length(); j++) {
                if (m[i] == m[j]) {
                    k = k + 1;}
                }
            }
        if (k>0) {
            return true;
        } else {
            return false;
        }
    }

    // -2-
    public static String getInitials(String x) {
        String[] parts = x.split(" ");

        var a = parts[0];
        var b = parts[1];

        char a1 = a.charAt(0);         
        char b1 = b.charAt(0);

        String a2 = String.valueOf(a1);
        String b2 = String.valueOf(b1);

        return a2+b2;
    }
    
    // -3-
    public static int differenceEvenOdd(int[] x) {
        // return x[0];
        int ch = 0; 
        int nech = 0;
        int k = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i]%2==0) {
                ch=ch+x[i];
            } else {
                nech = nech+x[i];

            }
        }
        k = Math.abs(ch-nech);
        return k;
        }

    // -4-
    public static boolean equalToAvg(int[] x) {
        int s = 0;
        for (int i = 0; i<x.length; i++) {
            s = s + x[i];
        }
        if (s%x.length == 0) {
            s = s / x.length;
        }
        
        int n = 0;
        for (int i = 0; i<x.length; i++) {
            if (x[i] == s) {
                n=n+1;
            } 
        } 
        if (n>0) {
            return true;
        } else {
            return false;
        }
    }
    
    // -5- 
    public static String indexMult(int[] x) {
        int [] a = new int[x.length];
        for (int i = 0; i<x.length; i++) {
            a[i] = x[i]*i;
        }
        return Arrays.toString(a);

    }

    // -6- 
    public static String reverse(String x) {
        char[] charArray = x.toCharArray();
        String result = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            result = result + charArray[i];
        }
        return result;
}
    // -7- 
    public static int Tribonacci(int x) {
        int a1 = 0;
        int a2 = 0;
        int a3 = 1;
        int a4;

        if (x <= 2) {
            return 0;
        } 
        x = x-3;
        for (int i = 1; i<=x; i++) {
            a4 = a1+a2+a3;
            a1 = a2;
            a2 = a3;
            a3 = a4;
        }
        return a3;
    }
    
    // -8- 
    public static String pseudoHash(int x) {
        String chars = "0123456789abcdef";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < x; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();

    }

    // -9- 
    public static String botHelper(String x) {
        x = x.toLowerCase();
        String a = "help";
        String[] parts = x.split(" ");

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(a)) {
                return "Calling for a staff member";

            }

        }
        return "Keep waiting";

    }

    // -10- 
    public static boolean isAnagram(String x, String y) {

        x = x.replace(" ", "");
        y = y.replace(" ", "");
        char[] x1 = x.toLowerCase().toCharArray();
        char[] y1 = y.toLowerCase().toCharArray();

        // return x;

        Arrays.sort(x1);
        Arrays.sort(y1);
        return Arrays.equals(x1, y1);
        // return Arrays.toString(x1);

    }


}
