package com.deep.tripease.exception;

public class CabNotFoundException extends RuntimeException{
    public CabNotFoundException(String message){
        super(message);
    }
}
