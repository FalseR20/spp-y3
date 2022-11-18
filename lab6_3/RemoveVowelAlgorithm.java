package lab6_3;

public class RemoveVowelAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encryptData(String plainText) {
        return plainText.replaceAll("[AEIOUaeiou]", "");
    }
}
