package lab2_2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Program {
    final static File FILES_DIR = new File("./lab2_2/files");
    final static boolean IS_DEBUG = false;

    public static void main(String[] args) {
        var joinLinesNumbers = new int[]{0, 0};
        var files = new File[]{
                null,
                null,
                new File(FILES_DIR, "3.txt"),
        };

        try {
            // Parsing of args block
            var i = 0;
            while (i < args.length && args[i].charAt(0) == '-') {
                var flag = args[i++].substring(1);
                var lineNumber = Integer.parseInt(flag) - 1;
                joinLinesNumbers[lineNumber] = Integer.parseInt(args[i++]) - 1;
            }
            var args_left = args.length - i;
            if (args_left < 2 || args_left > 3)
                throw new Exception("Count of files args must be not less than 2 and not more than 3");
            for (var j = 0; j < args_left; j++, i++) {
                files[j] = new File(FILES_DIR, args[i]);
            }
            if (IS_DEBUG)
                printFlagsParams(System.out, "Debug", joinLinesNumbers, files);

            // Checking
            for (i = 0; i < 2; i++) {
                if (!files[i].exists())
                    throw new Exception(String.format("File '%s' doesn't exist", files[i].toString()));
            }

            // Reading files
            var tables = new String[2][][];
            for (i = 0; i < 2; i++) {
                tables[i] = getTable(files[i]);
            }
            if (IS_DEBUG)
                for (i = 0; i < 2; i++) {
                    System.out.println(Arrays.deepToString(tables[i]));
                }

            // Joining
            try (var stream = new FileOutputStream(files[2])) {
                String word;
                StringBuilder lineToWrite;
                for (i = 0; i < tables[0].length; i++) {
                    word = tables[0][i][joinLinesNumbers[0]];
                    int wordIndex = -1;
                    for (int j = 0; j < tables[1].length; j++) {
                        if (tables[1][j][joinLinesNumbers[1]].equals(word))
                            wordIndex = j;
                    }
                    lineToWrite = new StringBuilder();
                    if (wordIndex != -1) {
                        for (var j = 0; j < tables[0][i].length; j++) {
                            if (j != joinLinesNumbers[0])
                                lineToWrite.append(tables[0][i][j]).append(" ");
                        }
                        lineToWrite.append(String.format("| %s |", word));
                        for (var j = 0; j < tables[1][wordIndex].length; j++) {
                            if (j != joinLinesNumbers[0])
                                lineToWrite.append(" ").append(tables[1][wordIndex][j]);
                        }
                        lineToWrite.append("\n");
                        stream.write(lineToWrite.toString().getBytes(StandardCharsets.UTF_8));
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException("Cannot read file");
            }


        } catch (Exception exception) {
            printFlagsParams(System.err, exception.getMessage(), joinLinesNumbers, files);
        }
    }

    static void printFlagsParams(PrintStream stream, String message, int[] joinLinesNumbers, File[] files) {
        stream.println(message);
        stream.printf("Lines to join: %s\n", Arrays.toString(joinLinesNumbers));
        stream.printf("Files to use:  %s\n\n", Arrays.toString(files));
    }

    static String[][] getTable(File file) {
        try (var stream = new FileInputStream(file)) {
            var text = new String(stream.readAllBytes());
            var lines = text.split("\r\n");
            var table = new String[lines.length][];
            for (var i = 0; i < lines.length; i++) {
                table[i] = lines[i].split(" ");
            }

            return table;
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read file");
        }
    }
}