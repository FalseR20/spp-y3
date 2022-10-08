package lab3_1;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Program {
    public static void main(String[] args){
        var array1 = new FloatSet(1F, 3F);
        var array2 = new FloatSet(3F, 2F, 4F);

        var out = new PrintWriter(System.out,true, StandardCharsets.UTF_8);
        out.printf("array1 toString: %s\n", array1);
        out.printf("array2 toString: %s\n", array2);
        out.printf("arrays are equal: %s\n", array1 == array2);
        out.printf("array1 contains 1: %s\n", array1.contains(1F));
        out.printf("array2 contains 1: %s\n", array2.contains(1F));
        array2.remove(1F);
        out.printf("array2 remove 1: %s\n", array2);
        array2.add(1F);
        out.printf("array2 add 1: %s\n", array2);
        out.printf("length of array1: %s\n", array1.length());

        out.printf("array1 ∨ array2: %s\n", array1.or(array2));
        out.printf("array2 ∧ array2: %s\n", array1.and(array2));

    }
}
