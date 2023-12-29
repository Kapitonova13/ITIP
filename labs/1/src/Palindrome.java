public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " is Paindrome");
            } else {
                System.out.println(s + " is not Paindrome");
            }
        }
    }
    public static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        String result = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            result = result + charArray[i];
        }
        return result;
    }
    public static boolean isPalindrome(String s) {
        String reverse = reverseString(s);
        if (s.equals(reverse)) {
            return true;
        }
        return false;
    }
}


