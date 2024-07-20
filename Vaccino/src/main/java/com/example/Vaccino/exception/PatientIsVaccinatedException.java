package com.example.Vaccino.exception;

public class PatientIsVaccinatedException extends RuntimeException{

    public PatientIsVaccinatedException(String m){
        super(m);
    }
}
