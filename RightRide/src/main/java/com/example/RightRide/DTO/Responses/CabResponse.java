package com.example.RightRide.DTO.Responses;

import com.example.RightRide.Enum.CabType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    private String cabNumber;

    private CabType cabType;

    private double farePerKm;

    private boolean booked;
}
