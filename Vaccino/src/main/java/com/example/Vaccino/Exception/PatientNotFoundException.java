package com.example.Vaccino.Exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String m){
        super(m);
    }
}
