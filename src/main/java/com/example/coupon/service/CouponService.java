package com.example.coupon.service;

import com.example.coupon.model.Coupon;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CouponService {

    public boolean validateCoupon(Coupon coupon) {

        if (coupon == null) return false;

        if (!coupon.isActive()) return false;

        if (coupon.getExpiryDate() == null ||
            coupon.getExpiryDate().isBefore(LocalDate.now())) return false;

        if (coupon.getDiscount() <= 0) return false;

        return true;
    }
}