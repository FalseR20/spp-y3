package lab6_3;

import java.io.File;
import java.io.IOException;

public class Program {
    /**
     * <a href="https://refactoring.guru/ru/design-patterns/strategy">Strategy pattern</a>
     */

    public static void main(String[] args) throws IOException {
        final File FILES_DIR = new File("./lab6_3/files");
        final File FILE_ORIG = new File(FILES_DIR, "orig.txt");

        new Encryptor(new RemoveVowelAlgorithm()).encryptFile(FILE_ORIG, new File(FILES_DIR, "remove_vowel.txt"));
        new Encryptor(new MoveLetterAlgorithm()).encryptFile(FILE_ORIG, new File(FILES_DIR, "move_letter.txt"));
        new Encryptor(new XorAlgorithm()).encryptFile(FILE_ORIG, new File(FILES_DIR, "xor_letter.txt"));
    }
}
