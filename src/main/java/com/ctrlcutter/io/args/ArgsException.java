package com.ctrlcutter.io.args;

public class ArgsException extends RuntimeException {

    public ArgsException(String exceptionString) {
        super(exceptionString);
    }

    public ArgsException(String exceptionString, Throwable exceptionThrowable) {
        super(exceptionString, exceptionThrowable);
    }
}
