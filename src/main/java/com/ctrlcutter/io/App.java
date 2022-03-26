package com.ctrlcutter.io;

import com.ctrlcutter.io.args.Args;
import com.ctrlcutter.io.writing.ScriptFileWriter;

public class App {

    public static void main(String[] args) {

        Args arguments = new Args(args, "a?,p*,c*");
        boolean appendToFile = arguments.getBoolean('a');
        String filePath = arguments.getString('p');
        String fileContent = arguments.getString('c');

        ScriptFileWriter.writeToFile(filePath, fileContent, appendToFile);
    }
}
