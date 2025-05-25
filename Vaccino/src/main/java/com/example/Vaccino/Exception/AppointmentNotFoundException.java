package com.example.Vaccino.Exception;

public class AppointmentNotFoundException extends RuntimeException {

    public AppointmentNotFoundException(String m){
        super(m);
    }
}
