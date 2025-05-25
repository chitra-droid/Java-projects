package com.example.RightRide.DTO.Responses;

import com.example.RightRide.Enum.Rating;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {

    private String name;
    private long mobileNo;
    private CabResponse cabResponse;
    private Rating rating;
}
