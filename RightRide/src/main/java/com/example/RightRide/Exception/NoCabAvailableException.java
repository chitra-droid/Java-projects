package com.example.RightRide.exception;

import org.springframework.data.jpa.repository.JpaRepository;

public class NoCabAvailableException extends RuntimeException {
    public NoCabAvailableException(String m){
        super(m);
    }
}
