package com.ctrlcutter.io.os;

public class OSHandlerProvider {

    public static IOSPathHandler getPathHandler() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") >= 0) {
            return new WindowsOSHandler();
        }

        return new DefaultOSHandler();
    }
}
