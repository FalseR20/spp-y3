package lab1;

import java.util.Arrays;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        Tasks.countSymbols(1, 4, 10000, 24, 567, 0);
        Tasks.shiftLeft(new double[]{1, 2, 3, 4, 5}, 2);
        Tasks.xor("abc", "a1яh");
    }
}

/**
 * Вариант 9
 */
class Tasks {

    public static void countSymbols(int... values) {
        printTask("1");

        var map = new HashMap<Integer, Integer>();
        for (var value : values) {
            var countOfSymbols = Integer.toString(value).length();
            var prevCount = map.getOrDefault(countOfSymbols, 0);
            map.put(countOfSymbols, prevCount + 1);
        }
        for (var set : map.entrySet()) {
            System.out.printf("Count of integers with %d symbols: %d\n", set.getKey(), set.getValue());
        }
    }

    public static void shiftLeft(double[] array, int shift) {
        printTask("shiftLeft");

        System.out.printf("Received array: %s, need to shift on %d right\n", Arrays.toString(array), shift);

        var temp = new double[shift];
        var shiftFromEnd = array.length - shift;
        System.arraycopy(array, 0, temp, 0, shift);
        System.arraycopy(array, shift, array, 0, shiftFromEnd);
        System.arraycopy(temp, 0, array, shiftFromEnd, shift);

        System.out.printf("Shifted  array: %s\n", Arrays.toString(array));
    }

    public static void xor(String str1, String str2) {
        printTask("xor");

        String strMax, strMin;
        if (str1.length() >= str2.length()) {
            strMax = str1;
            strMin = str2;
        } else {
            strMax = str2;
            strMin = str1;
        }
        var maxCharArray = strMax.toCharArray();
        var minCharArray = strMin.toCharArray();
        for (int i = 0; i < strMin.length(); i++) {
//            System.out.printf("Chars: %s and %s\n", Integer.toBinaryString(maxCharArray[i]), Integer.toBinaryString(minCharArray[i]));
            maxCharArray[i] ^= minCharArray[i];
//            System.out.printf("Final: %s\n", Integer.toBinaryString(maxCharArray[i]));
        }
        var result = new String(maxCharArray);
        System.out.printf("Xored string: %s\n", result);
    }

    static void printTask(String task) {
        System.out.printf("\n--------------- Task %s ---------------%s\n\n", task, "-".repeat(9 - task.length()));
    }

}
