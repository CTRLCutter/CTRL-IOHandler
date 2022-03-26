package com.ctrlcutter.io.writing;

public class ScriptFileWritingException extends RuntimeException {

    public ScriptFileWritingException(String exceptionString) {
        super(exceptionString);
    }

    public ScriptFileWritingException(String exceptionString, Throwable exceptionThrowable) {
        super(exceptionString, exceptionThrowable);
    }
}
