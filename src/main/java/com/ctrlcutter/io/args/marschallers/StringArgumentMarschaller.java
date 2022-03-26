package com.ctrlcutter.io.args.marschallers;

import java.util.Iterator;

public class StringArgumentMarschaller implements IArgumentMarschaller {

    private String stringValue;

    @Override
    public void setCurrentArgument(Iterator<String> currentArgument) {

        this.stringValue = currentArgument.next();
    }

    public static String getValue(IArgumentMarschaller marschaller) {

        if (null != marschaller && marschaller instanceof StringArgumentMarschaller) {
            return ((StringArgumentMarschaller) marschaller).stringValue;
        }

        return "";
    }
}
