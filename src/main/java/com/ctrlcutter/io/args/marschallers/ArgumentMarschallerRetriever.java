package com.ctrlcutter.io.args.marschallers;

import com.ctrlcutter.io.args.ArgsException;

public class ArgumentMarschallerRetriever {

    public static IArgumentMarschaller retrieveArgumentMarschallerFromArgument(String elementType) {

        if (elementType.equals("?")) {
            return new BooleanArgumentMarschaller();
        } else if (elementType.equals("*")) {
            return new StringArgumentMarschaller();
        } else {
            throw new ArgsException("Failed to retrieve argument marschaller from element type " + elementType);
        }
    }
}
