package com.ctrlcutter.io.args.marschallers;

import java.util.Iterator;

public class BooleanArgumentMarschaller implements IArgumentMarschaller {

    private boolean booleanValue = false;

    @Override
    public void setCurrentArgument(Iterator<String> currentArgument) {

        this.booleanValue = Boolean.getBoolean(currentArgument.next());
    }

    public static boolean getValue(IArgumentMarschaller marschaller) {

        if (null != marschaller && marschaller instanceof BooleanArgumentMarschaller) {
            return ((BooleanArgumentMarschaller) marschaller).booleanValue;
        }

        return false;
    }
}
