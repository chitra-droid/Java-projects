package com.example.RightRide.dto.Responses;

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
}
