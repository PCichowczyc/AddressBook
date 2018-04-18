package com.pcichocki.adressbook.exceptions;

/**
 * Created by CT88AB on 2018-03-13.
 */
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {

    }

    public PersonNotFoundException(String message)
    {
        super(message);
    }
}
