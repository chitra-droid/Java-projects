package com.example.RightRide.transformers;

import com.example.RightRide.Entity.Cab;
import com.example.RightRide.dto.Requests.CabRequest;
import com.example.RightRide.dto.Responses.CabResponse;

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
