package com.extnds.nemo.website.commons.exceptions;

public class InternalServerException extends RuntimeException {

    public InternalServerException(Exception e) {
        super(e);
    }
}
