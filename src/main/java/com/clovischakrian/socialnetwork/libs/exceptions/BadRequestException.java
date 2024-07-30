package com.clovischakrian.socialnetwork.libs.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException() {
        super("Bad request exception ocurred.");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
