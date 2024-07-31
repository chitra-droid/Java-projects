package com.example.RightRide.dto.Requests;

import com.example.RightRide.Enum.CabType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
