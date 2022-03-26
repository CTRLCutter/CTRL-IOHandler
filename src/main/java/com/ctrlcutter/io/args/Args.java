package com.ctrlcutter.io.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.ctrlcutter.io.args.marschallers.ArgumentMarschallerRetriever;
import com.ctrlcutter.io.args.marschallers.BooleanArgumentMarschaller;
import com.ctrlcutter.io.args.marschallers.IArgumentMarschaller;
import com.ctrlcutter.io.args.marschallers.StringArgumentMarschaller;

public class Args {

    private Map<Character, IArgumentMarschaller> marschallers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;

    public Args(String[] args, String schema) {

        this.marschallers = new HashMap<>();
        this.argsFound = new HashSet<>();
        parseSchema(schema);
        parseArgumentStrings(args);
    }

    private void parseSchema(String schema) {

        String[] elements = schema.split(",");

        for (String element : elements) {

            if (elements.length > 0) {
                parseSchemaElement(element);
            }
        }
    }

    private void parseSchemaElement(String element) {

        char elementId = element.charAt(0);
        String elementType = element.substring(1);
        IArgumentMarschaller argumentMarschaller = ArgumentMarschallerRetriever.retrieveArgumentMarschallerFromArgument(elementType);

        validateSchemaId(elementId);
        this.marschallers.put(elementId, argumentMarschaller);
    }

    private void validateSchemaId(char elementId) {

        if (!Character.isLetter(elementId)) {
            throw new ArgsException("Error during schema parsing. Invalid argument format of " + elementId);
        }
    }

    private void parseArgumentStrings(String[] arguments) {

        List<String> argumentList = Arrays.asList(arguments);

        for (this.currentArgument = argumentList.listIterator(); currentArgument.hasNext();) {

            String argsString = this.currentArgument.next();
            if (argsString.startsWith("-")) {
                parseArgumentCharacters(argsString.substring(1));
            } else {
                this.currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argumentCharacters) {

        for (char c : argumentCharacters.toCharArray()) {
            parseArgumentCharacter(c);
        }
    }

    private void parseArgumentCharacter(char argumentCharacter) {

        IArgumentMarschaller marschaller = this.marschallers.get(argumentCharacter);

        if (null == marschaller) {
            throw new ArgsException("Unable to retrieve argument marschaller from type " + argumentCharacter);
        }

        this.argsFound.add(argumentCharacter);
        marschaller.setCurrentArgument(this.currentArgument);
    }

    public boolean getBoolean(char arg) {
        return BooleanArgumentMarschaller.getValue(this.marschallers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarschaller.getValue(this.marschallers.get(arg));
    }
}
