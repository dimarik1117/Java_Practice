import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 {
    public static void main(String[] args) {
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you di this task not by yourself, you have to understand every single line of code.") + "\n");

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper") + "\n");

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1) + "\n");

        System.out.println(numCheck(243));
        System.out.println(numCheck(52) + "\n");

        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}) + "\n");

        System.out.println(salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Banana", "Shop2", "Shop3", "Shop4"}, {"Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}}));
        System.out.println(salesData(new String[][] {{"Fridge", "Shop2", "Shop3"}, {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}) + "\n");

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish") + "\n");

        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}) + "\n");

        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words") + "\n");

        System.out.println(Arrays.deepToString(dataScience(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {5, 5, 5, 5, 5}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}})));
        System.out.println(Arrays.deepToString(dataScience(new int[][]{{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}})));
    }
    public static String replaceVowels(String words) {
        char[] arr = words.toLowerCase().toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'o' || arr[i] == 'i' || arr[i] == 'u' || arr[i] == 'y')
                arr[i] = '*';
            res += arr[i];
        }
        return res;
    }
    public static String stringTransform(String word) {
        char[] arr = word.toLowerCase().toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1 < arr.length) && (arr[i] == arr[i + 1])) {
                res += "Double" + word.substring(i, i + 1).toUpperCase();
                i++;
            }
            else
                res += arr[i];
        }
        return res;
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        boolean res = false;
        int[] arr1 = {a, b, c};
        int[] arr2 = {w, h};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if ((arr1[0] <= arr2[0]) && (arr1[1] <= arr2[1]))
            res = true;
        return res;
    }
    public static boolean numCheck(int num) {
        int temp = num, sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp > 0) {
            arr.add(temp%10);
            temp /= 10;
        }
        for (int i = 0; i < arr.toArray().length; i++) {
            sum = sum + arr.get(i) * arr.get(i);
        }
        return num % 2 == sum % 2;
    }
    public static int countRoots(int[] nums) {
        int roots = 0;
        int D = nums[1] * nums[1] - 4 * nums[0] * nums[2];
        if (D > 0) {
            double x1 = (-nums[1] - Math.sqrt(D)) / (2 * nums[0]);
            double x2 = (-nums[1] + Math.sqrt(D)) / (2 * nums[0]);
            if (x1 == (int) x1)
                roots += 1;
            if (x2 == (int) x2)
                roots += 1;
        }
        else if (D == 0) {
            double x = (double) -nums[1] / (2 * nums[0]);
            if (x == (int) x)
                roots += 1;
        }
        return roots;
    }
    public static ArrayList<String> salesData(String[][] mass_arr) {
        ArrayList<String> goods = new ArrayList<>();
        int[] col = new int[mass_arr.length];
        for (int i = 0; i < mass_arr.length; i++) {
            col[i] = mass_arr[i].length;
        }
        Arrays.sort(col);
        for (int i = 0; i < mass_arr.length; i++) {
            if (mass_arr[i].length == col[col.length - 1])
                goods.add(mass_arr[i][0]);
        }
        return goods;
    }
    public static boolean validSplit(String words) {
        char[] arr = words.toLowerCase().toCharArray();
        int num1 = 0, num2 = 0;
        for (int i = 1; i < (arr.length - 1); i++) {
            if (arr[i] == ' ')
                num1 += 1;
            if (arr[i] == ' ' && arr[i-1] == arr[i+1])
                num2 += 1;
        }
        return num1 == num2;
    }
    public static boolean waveForm(int[] nums) {
        boolean res = true;
        if (nums[0] > nums[1]) {
            for (int i = 1; i < (nums.length - 2); i += 2) {
                if ((nums[i] < nums[i-1] && nums[i] < nums[i+1]) && (nums[i+1] > nums[i] && nums[i+1] > nums[i+2]))
                    res = true;
                else {
                    res = false;
                    break;
                }
            }
        }
        else if (nums[0] < nums[1]) {
            for (int i = 1; i < (nums.length - 2); i += 2) {
                if ((nums[i] > nums[i-1] && nums[i] > nums[i+1]) && (nums[i+1] < nums[i] && nums[i+1] < nums[i+2]))
                    res = true;
                else {
                    res = false;
                    break;
                }
            }
        }
        else
            res = false;
        return res;
    }
    public static char commonVowel(String words) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] arr = words.toLowerCase().toCharArray();
        int[] col = new int[] {0, 0, 0, 0, 0, 0};
        int max = 0, max_index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (arr[i] == vowels[j])
                    col[j]++;
            }
        }
        for (int i = 0; i < col.length; i++) {
            if (max < col[i]) {
                max = col[i];
                max_index = i;
            }
        }
        return vowels[max_index];
    }
    public static int[][] dataScience(int[][] mass_arr) {
        int[][] arr = new int[mass_arr.length][mass_arr.length];
        int[] sum = new int[mass_arr.length];
        for (int k = 0; k < mass_arr.length; k++) {
            for (int l = 0; l < mass_arr[k].length; l++) {
                if (k != l)
                    sum[l] += mass_arr[k][l];
            }
        }
        for (int i = 0; i < mass_arr.length; i++) {
            for (int j = 0; j < mass_arr[i].length; j++) {
                arr[i][j] = mass_arr[i][j];
                if (i == j)
                    arr[i][j] = Math.round((float) sum[i] / (mass_arr.length - 1));
            }
        }
        return arr;
    }
}
