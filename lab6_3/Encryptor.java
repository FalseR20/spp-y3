package lab6_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private final EncryptionAlgorithm algorithm;

    public Encryptor(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void encryptFile(File fileInput, File outputFile) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(fileInput.toString()));
        List<String> encryptedStrings = new ArrayList<>();
        for (String string : strings) {
            encryptedStrings.add(algorithm.encryptData(string));
        }
        Files.write(Paths.get(outputFile.toString()), encryptedStrings);
    }
}
