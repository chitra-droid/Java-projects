package com.example.RightRide.Exception;

public class NoCabAvailableException extends RuntimeException {
    public NoCabAvailableException(String m){
        super(m);
    }
}
