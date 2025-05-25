package com.example.RightRide.DTO.Requests;

import com.example.RightRide.Enum.CabType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest {

     String cabNumber;

     CabType cabType;

     double farePerKm;

}
