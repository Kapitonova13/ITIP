public class Main1 {
    public static void main(String[] args)  {
        System.out.println("-1-");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        
        System.out.println("-2-");

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println("-3-");

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("-4-");

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 2));

        System.out.println("-5-");

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println("-6-");

        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println("-7-");

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("-8-");

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println("-9-");

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("-10-");

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static float convert(int x) {
        return x * 3.785f;
    }

    public static int fitCalc(int x, int y) {
        if (y == 1) {
            return x;
        } else if (y==2){
            return x*2;
        } else if (y == 3) {
            return x*3;
        } else {
            return 0;
        } 
    }

    public static int containers(int x, int y, int z) {
        return x*20 + y*50 + z*100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x+y<=z || x+z<=y || y+z<=x) {
            return "не треугольник";
        } else if (x==y & x==z & y==z)  {
            return "равносторонний";
        } else if (x==y || x==z || y==z) {
            return "равнобедренный";
        } else {
            return "разные стороны";
        }
    }

    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x:y;
    }

    public static int howManyItems(int x, double y, double z) {


        double k = x/2/(y*z);
        int i = (int) k;
        return i;

    }

    public static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
             result = result * i;
        }
        return result;
    }

    public static int gcd(int x, int y) {
        while (x!=y) {
            if (x>y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }

    public static int ticketSaler(int x, int y) {
        return (int) (x*y*0.72f);

    }

    public static int tables(int x, int y) {
        int k = y * 2;
        if (x > k) {
            if (x/2 == 0) {
                return (x - k)/2;
            } else {
                return (x - k)/2 + 1;
            }
        } else {
            return 0;
        }

    }

}
