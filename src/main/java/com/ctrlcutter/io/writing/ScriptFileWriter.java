package com.ctrlcutter.io.writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.ctrlcutter.io.os.IOSPathHandler;
import com.ctrlcutter.io.os.OSHandlerProvider;

public class ScriptFileWriter {

    /**
     * This method enables you to write text content to a file.
     * 
     * @param fileName
     *        The path to the file.
     * @param content
     *        The content you want to write.
     * @param appendToExistingFile
     *        The flag if you want to create a new file with the given content
     *        or you want to append to a pre-existing file.
     */
    public static void writeToFile(String fileName, String content, boolean appendToExistingFile) {
        IOSPathHandler pathHandler = OSHandlerProvider.getPathHandler();
        String fileContent = reformatContent(content);
        String targetFilePath = pathHandler.getFolderPath() + fileName;

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(targetFilePath, appendToExistingFile))) {
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            throw new ScriptFileWritingException("Error during file writing. File could not be successfully written to " + fileName, e);
        }
    }

    private static String reformatContent(String baseContent) {
        String formattedContent = baseContent.replaceAll("%-%", " ");
        return formattedContent;
    }
}
