package com.example.coupon.controller;

import com.example.coupon.model.Coupon;
import com.example.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/validate")
    public String validateCoupon(@RequestBody Coupon coupon) {

        boolean isValid = couponService.validateCoupon(coupon);

        if (isValid) {
            return "Valid Coupon ✅";
        } else {
            return "Invalid Coupon ❌";
        }
    }
}

