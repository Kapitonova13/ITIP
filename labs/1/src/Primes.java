public class Primes {
    public static void main(String[] args)  {
        for (int i = 2; i <= 100; i++){
            if (isPrime(i)) {
                System.out.println(i);
            }        
        } 
    }
    public static boolean isPrime(int n) {
        int a = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                a = a + 1;
            }}
        if (a==0) {
            return true;
        } else {
            return false;
        }
    }
}


    