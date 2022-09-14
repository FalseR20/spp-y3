package lab2_1;

import java.io.*;
import java.util.Random;


public class Task1 {
    final File FILES_DIR = new File("./lab2_1/files");
    final File NOUN_FILE = new File(FILES_DIR, "noun.txt");
    final File VERB_FILE = new File(FILES_DIR, "verb.txt");
    final File PREPOSITION_FILE = new File(FILES_DIR, "preposition.txt");
    final File ADJECTIVE_FILE = new File(FILES_DIR, "adjective.txt");
    final File RESULT = new File(FILES_DIR, "result.txt");
    final Random RANDOMIZER = new Random();

    Task1() {
        FILES_DIR.mkdir();
    }


    public void main() {
        var nouns = get_words_array(NOUN_FILE);
        var verbs = get_words_array(VERB_FILE);
        var prepositions = get_words_array(PREPOSITION_FILE);
        var adjectives = get_words_array(ADJECTIVE_FILE);
        var result_string = new StringBuilder(50);

        for (var i = 0; i < 20; i++) {
            var first_word = get_random(nouns);
            first_word = first_word.substring(0, 1).toUpperCase() + first_word.substring(1);
            var sentence = String.format("%s %s %s %s %s.\n",
                    first_word,
                    get_random(verbs),
                    get_random(prepositions),
                    get_random(adjectives),
                    get_random(nouns)
            );
            result_string.append(sentence);
            System.out.print(sentence);
        }
        try (var stream = new FileOutputStream(RESULT)) {
            var char_array = result_string.toString().getBytes();
            stream.write(char_array);
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read file");
        }
    }

    String[] get_words_array(File file) {
        try (var stream = new FileInputStream(file)) {
            var text = new String(stream.readAllBytes());
            return text.split("\r\n");
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read file");
        }
    }

    String get_random(String[] words) {
        return words[RANDOMIZER.nextInt(words.length)];
    }
}
