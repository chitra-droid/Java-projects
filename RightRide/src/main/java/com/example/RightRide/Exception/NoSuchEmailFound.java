package com.example.RightRide.exception;

public class NoSuchEmailFound extends RuntimeException{

    public NoSuchEmailFound(String m){
        super(m);
    }
}
