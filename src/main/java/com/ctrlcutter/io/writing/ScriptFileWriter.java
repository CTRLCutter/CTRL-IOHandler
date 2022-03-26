package com.ctrlcutter.io.writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScriptFileWriter {

    /**
     * This method enables you to write text content to a file.
     * 
     * @param filePath
     *        The path to the file.
     * @param content
     *        The content you want to write.
     * @param appendToExistingFile
     *        The flag if you want to create a new file with the given content
     *        or you want to append to a pre-existing file.
     */
    public static void writeToFile(String filePath, String content, boolean appendToExistingFile) {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, appendToExistingFile))) {
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new ScriptFileWritingException("Error during file writing. File could not be successfully written to " + filePath, e);
        }
    }
}
