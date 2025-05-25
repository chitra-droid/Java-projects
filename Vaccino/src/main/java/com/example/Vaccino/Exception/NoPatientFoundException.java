package com.example.Vaccino.Exception;

public class NoPatientFoundException extends RuntimeException{

   public NoPatientFoundException(String mess){
        super(mess);
    }
}
