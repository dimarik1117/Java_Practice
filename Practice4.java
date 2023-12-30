import java.util.*;

public class Practice4 {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi" + "\n"));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3) + "\n");

        System.out.println((Arrays.toString(binarySystem(3))));
        System.out.println((Arrays.toString(binarySystem(4))) + "\n");

        System.out.println(alphabeticRow("ababa"));
        System.out.println(alphabeticRow("abcdzyxw") + "\n");

        System.out.println(countSame("aaabbcdd"));
        System.out.println(countSame("vvvvaajaaaaa") + "\n");

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one") + "\n");

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898") + "\n");

        int[][] array1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] array2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(array1));
        System.out.println(shortestWay(array2)  + "\n");

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")  + "\n");

        System.out.println(switchNums(456, 123));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }
    public static String nonRepeatable(String s) {
        if (s.length() <= 1)
            return s;
        char firstChar = s.charAt(0);
        String restOfString = s.substring(1);
        restOfString = restOfString.replace(String.valueOf(firstChar), "");
        return firstChar + nonRepeatable(restOfString);
    }
    public static ArrayList<String> generateBrackets(int n){
        if (n <= 0) {
            return new ArrayList<>(List.of(""));
        }
        if (n == 1) {
            return new ArrayList<>(List.of("()"));
        }
        ArrayList<String> listOfBrackets = new ArrayList<>();
        for (String item: generateBrackets(n - 1)){

            String outerBrackets = "(" + item + ")";
            String leftBrackets = "()" + item;
            String rightBrackets = item + "()";

            if (!listOfBrackets.contains(outerBrackets))
                listOfBrackets.add(outerBrackets);
            if (!listOfBrackets.contains(leftBrackets))
                listOfBrackets.add(leftBrackets);
            if (!listOfBrackets.contains(rightBrackets))
                listOfBrackets.add(rightBrackets);
        }
        return listOfBrackets;
    }
    public static String[] binarySystem(int num){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < (int) Math.pow(2, num); i++) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
            while (s.length() < num)
                s.insert(0, "0");
            if (!s.toString().contains("00"))
                str.append(s).append(" ");
        }
        return str.toString().split(" ");
    }
    public static String alphabeticRow(String string){
        int stringLength = string.length();
        if (stringLength <= 1) {
            return string;
        }
        String upperString = string.toUpperCase();
        String maxRow = String.valueOf(string.charAt(0));
        String currentRow = String.valueOf(string.charAt(0));

        for (int index = 0; index < stringLength - 1; index++){
            char currentChar = upperString.charAt(index);
            char nextChar = upperString.charAt(index + 1);
            if (currentChar >= 65 && currentChar <= 90 &&
                    nextChar >= 65 && nextChar <= 90 &&
                    currentChar + 1 == nextChar) {
                currentRow += string.charAt(index + 1);
                if (currentRow.length() > maxRow.length()){
                    maxRow = currentRow;
                }
            }
            else {
                currentRow = String.valueOf(string.charAt(index + 1));
            }
        }

        currentRow = String.valueOf(string.charAt(0));
        for (int index = 0; index < stringLength - 1; index++){
            char currentChar = upperString.charAt(index);
            char nextChar = upperString.charAt(index + 1);
            if (currentChar >= 65 && currentChar <= 90 &&
                    nextChar >= 65 && nextChar <= 90 &&
                    currentChar - 1 == nextChar) {
                currentRow += string.charAt(index + 1);
                if (currentRow.length() > maxRow.length()){
                    maxRow = currentRow;
                }
            }
            else {
                currentRow = String.valueOf(string.charAt(index + 1));
            }
        }
        return maxRow;
    }
    public static String countSame(String string){
        ArrayList<String> items = new ArrayList<>();
        int count = 1;
        char symbol = string.charAt(0);
        for (int index = 1; index < string.length(); index++){
            char currentChar = string.charAt(index);
            if (symbol == currentChar){
                count += 1;
            }
            else{
                String item = String.valueOf(symbol) + count;
                items.add(item);
                count = 1;
                symbol = currentChar;
            }
        }
        String item = String.valueOf(symbol) + count;
        items.add(item);

        Comparator<String> myCustomComparator = (s1, s2) -> {
            int num1 = Integer.parseInt(s1.substring(1));
            int num2 = Integer.parseInt(s2.substring(1));
            return Integer.compare(num1, num2);
        };
        items.sort(myCustomComparator);

        return String.join("",items);
    }
    public static int convertToNum(String str){
        String[] s = str.split(" ");
        StringBuilder string_b = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(s[i].charAt(0) == 'o')
                string_b.append(1);
            else if((s[i].charAt(0) == 'e') && (s[i].charAt(1) == 'l'))
                string_b.append(11);
            else if(s[i].charAt(1) == 'w'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(20);
                else
                    string_b.append(2);
            }
            else if(s[i].contains("lve"))
                string_b.append(12);
            else if(s[i].charAt(1) == 'h'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(30);
                else
                    string_b.append(s[i].contains("een") ? 13 : 3);
            }
            else if(s[i].charAt(1) == 'o'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(40);
                else
                    string_b.append(s[i].contains("een") ? 14 : 4);
            }
            else if((s[i].charAt(0) == 'f') && s[i].charAt(1) == 'i'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(50);
                else
                    string_b.append(s[i].contains("een") ? 15 : 5);
            }
            else if((s[i].charAt(0) == 's') && s[i].charAt(1) == 'i'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(60);
                else
                    string_b.append(s[i].contains("een") ? 16 : 6);
            }
            else if((s[i].charAt(0) == 's') && s[i].charAt(1) == 'e'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(70);
                else
                    string_b.append(s[i].contains("een") ? 17 : 7);
            }
            else if(s[i].charAt(0) == 'e'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(80);
                else
                    string_b.append(s[i].contains("een") ? 18 : 8);
            }
            else if(s[i].charAt(0) == 'n'){
                if(s[i].contains("ty") && (i == s.length - 1))
                    string_b.append(90);
                else
                    string_b.append(s[i].contains("een") ? 19 : 9);
            }
            else if((s[i].charAt(0) == 't') && s[i].charAt(1) == 'e'){
                string_b.append(10);
            }
            else if(s[i].contains("hun")){
                if(i == s.length - 1)
                    string_b.append("00");
                else if ((i == s.length - 2) && (!s[i + 1].contains("een") || !s[i + 1].contains("ten") ||
                        !s[i + 1].contains("ven") || !s[i + 1].contains("lve")))
                    string_b.append(0);
            }
        }
        return Integer.parseInt(string_b.toString());
    }
    public static String uniqueSubstring(String string) {
        String maxSubString = String.valueOf(string.charAt(0));
        String currentSubString = String.valueOf(string.charAt(0));
        for (int i = 1; i < string.length(); i++){
            String element = String.valueOf(string.charAt(i));
            if (!currentSubString.contains(element)){
                currentSubString += element;
                if (currentSubString.length() > maxSubString.length()){
                    maxSubString = currentSubString;
                }
            }
            else {
                currentSubString = element;
            }
        }
        return maxSubString;
    }
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;

        int[][] newMatrix = new int[n][n];
        newMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++){
            newMatrix[i][0] =  newMatrix[i - 1][0] + matrix[i][0];
            newMatrix[0][i] =  newMatrix[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                newMatrix[i][j] = matrix[i][j] + Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]);
            }
        }
        return newMatrix[n - 1][n - 1];
    }
    public static String numericOrder(String string) {
        String[] words = string.split(" ");
        String[] newString = new String[(words.length)];
        for (String word: words){
            for (int i = 1; i < words.length + 1; i++){
                String num = String.valueOf(i);
                if (word.contains(num)){
                    newString[i-1] = word.replace(num, "");
                    break;
                }
            }
        }
        return String.join(" ",newString);
    }
    public static int switchNums(int num1, int num2){
        String[] mass1 = String.valueOf(num1).split("");
        String[] mass2 = String.valueOf(num2).split("");
        Arrays.sort(mass1);
        for (int i = mass1.length-1; i >= 0; i--){
            for (int j = 0; j < mass2.length; j++){
                if (Integer.parseInt(mass1[i]) > Integer.parseInt(mass2[j])){
                    mass2[j] = mass1[i];
                    break;
                }
            }
        }
        int number = 0;
        for (int i = 0; i < mass2.length; i++){
            number += (int) (Integer.parseInt(mass2[i]) * Math.pow(10, mass2.length - i - 1));
        }
        return number;
    }
}