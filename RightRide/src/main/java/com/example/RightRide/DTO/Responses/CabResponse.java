package com.example.RightRide.dto.Responses;

import com.example.RightRide.Enum.CabType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
