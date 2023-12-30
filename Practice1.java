public class Practice1 {

    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8) + "\n");

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3) + "\n");

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4) + "\n");

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1) + "\n");

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9) + "\n");

        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2) + "\n");

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7) + "\n");

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28) + "\n");

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250) + "\n");

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
    public static double convert(double x) {
        return x * 3.785;
    }
    public static int fitCalc(int x, int y) {
        return x * y;
    }
    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }
    public static String triangleType(int x, int y, int z) {
        if ((x > y + z) || (y > x + z) || (z > x + y))
            return "not a triangle";
        else if (x == y && x == z)
            return "isosceles";
        else if ((x == y) || (x == z) || (y == z))
            return "equilateral";
        return "different-sided";
    }
    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }
    public static int howManyItems(float n, float w, float h) {
        return (int) (n / (2 * w * h));
    }
    public static int factorial(int x) {
        int f = 1;
        for (int i = 2; i <= x; i++) {
            f *= i;
        }
        return f;
    }
    public static int gcd(int x, int y) {
        int g = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0)
                g = i;
        }
        return g;
    }
    public static float ticketSaler(float x, float y) {
        return x * (y - y * 0.28f);
    }
    public static int tables(int  x, int y) {
        if (y * 2 >= x)
            return 0;
        else if (x % 2 == 1)
            return ((x + 1) / 2 - y);
        return (x / 2 - y);
    }
}
