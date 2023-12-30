import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Practice2 {

    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange") + "\n");

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama") + "\n");

        System.out.println(differenceEvenOdd(new int[] {44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}) + "\n");

        System.out.println(equalToAvg(new float[] {1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new float[] {1, 2, 3, 4, 6}) + "\n");

        System.out.println(indexMult(new int[] {1, 2, 3}));
        System.out.println(indexMult(new int[] {3, 3, -2, 408, 3, 31}) + "\n");

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox.") + "\n");

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11) + "\n");

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0) + "\n");

        System.out.println(botHelper("Hello, I'm under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please") + "\n");

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String word) {
        word = word.toLowerCase();
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                        return true;
                }
            }
        }
        return false;
    }
    public static String getInitials(String words) {
        char[] arr = words.toCharArray();
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            char s = words.charAt(i);
            if (Character.isUpperCase(s))
                res += arr[i];
        }
        return res;
    }
    public static int differenceEvenOdd(int[] nums) {
        int even = 0, odd = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                even += nums[i];
            else
                odd += nums[i];
        }
        return (Math.abs(even - odd));
    }

    public static boolean equalToAvg(float[] nums) {
        float sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == sum / nums.length) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> indexMult(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int mult = nums[i] * i;
            arr.add(mult);
        }
        return arr;
    }
    public static String reverse(String words) {
        String res = "";
        for (int i = words.length() - 1; i >= 0; i--) {
            res += words.charAt(i);
        }
        return res;
    }
    public static int Tribonacci(int num) {
        int[] f = new int[num];
        f[0] = 0;
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i < num; i++) {
            f[i] = f[i - 3] + f[i - 2] + f[i - 1];
        }
        return f[num-1];
    }
    public static String pseudoHash(int num) {
        char[] arr = new char[] {'a','b','c','d','e','f','0','1','2','3','4','5','6','7','8','9'};
        String res = "";
        Random r = new Random();
        for(int i = 0; i < num; i++) {
            res += arr[r.nextInt(arr.length)];
        }
        return res;
    }
    public static String botHelper(String words) {
        String[] a = words.split(" ");
        if (Arrays.asList(a).contains("help")) {
            return "Calling for a staff member";
        }
        else {
            return "Keep waiting";
        }
    }
    public static boolean isAnagram(String words1, String words2) {
        char[] a1 = words1.toCharArray();
        char[] a2 = words2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
