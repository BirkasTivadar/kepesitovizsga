package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Contacts or output must not be null");
        }

        Path file = Path.of(output);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {

            for (String name : contacts.keySet()) {
                writer.write(name + ": " + contacts.get(name) + "\n");
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
