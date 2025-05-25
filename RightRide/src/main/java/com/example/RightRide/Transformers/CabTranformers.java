package com.example.RightRide.Transformers;

import com.example.RightRide.Entity.Cab;
import com.example.RightRide.DTO.Requests.CabRequest;
import com.example.RightRide.DTO.Responses.CabResponse;

public class CabTranformers {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabType(cabRequest.getCabType())
                .cabNumber(cabRequest.getCabNumber())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .booked(cab.isBooked())
                .cabNumber(cab.getCabNumber())
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
