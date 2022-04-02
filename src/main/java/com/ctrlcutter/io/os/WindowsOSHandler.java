package com.ctrlcutter.io.os;

import java.util.Map;

public class WindowsOSHandler implements IOSPathHandler {

    @Override
    public String getFolderPath() {
        Map<String, String> map = System.getenv();
        String basePath = map.get("ProgramData") + "\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\";

        return basePath;
    }
}
