package lab2_2;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        try {
            var join_lines = new int[]{0, 0};
            File[] files;
            var i = 0;
            while (args[i].charAt(0) == '-') {
                var flag = args[i].substring(1);

                join_lines[Integer.getInteger(flag)] = Integer.getInteger(args[++i]);
            }
//            while ()
        } catch (Exception exception) {
            System.err.println("Invalid flags");
        }

//    var tasks = new Task2();
//        tasks.main();
    }
}