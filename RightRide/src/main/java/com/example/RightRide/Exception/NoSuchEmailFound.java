package com.example.RightRide.Exception;

public class NoSuchEmailFound extends RuntimeException{

    public NoSuchEmailFound(String m){
        super(m);
    }
}
