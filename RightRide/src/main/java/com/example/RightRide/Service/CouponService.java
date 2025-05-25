package com.example.RightRide.Service;

import com.example.RightRide.Entity.Coupon;
import com.example.RightRide.Repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {


    private final CouponRepository couponRepository;

    public String addCoupon(String couponCode, int Discount) {
        Coupon coupon = Coupon.builder()
                       .couponCode(couponCode)
                       .percentageDiscount(Discount)
                       .build();
        couponRepository.save(coupon);
        return "Coupon added successfully!";
    }
}
