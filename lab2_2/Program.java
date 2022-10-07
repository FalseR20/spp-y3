package lab2_2;

import java.io.File;
import java.util.Arrays;

public class Program {
    final static File FILES_DIR = new File("./lab2_2/files");

    public static void main(String[] args) {
        var joinLinesNumbers = new int[]{0, 0};
        var files = new File[]{
                new File(FILES_DIR, "1.txt"),
                new File(FILES_DIR, "2.txt"),
                new File(FILES_DIR, "3.txt"),
        };

        try {
            // Parsing of args block
            var i = 0;
            while (args[i].charAt(0) == '-') {
                var flag = args[i++].substring(1);
                var lineNumber = Integer.parseInt(flag) - 1;
                joinLinesNumbers[lineNumber] = Integer.parseInt(args[i++]);
            }
            var args_left = args.length - i;
//            if (args_left < 2 || args_left > 3)
//                throw new Exception("Count of files args must be not less than 2 and not more than 3");
            for (var j = 0; j < args_left; j++, i++) {
                files[j] = new File(FILES_DIR, args[i]);
            }
//            throw new Exception("DEBUG");

            // Joining


        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            System.err.println(Arrays.toString(joinLinesNumbers));
            System.err.println(Arrays.toString(files));
        }
    }
}