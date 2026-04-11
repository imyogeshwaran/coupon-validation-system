package com.example.coupon;

import com.example.coupon.model.Coupon;
import com.example.coupon.service.CouponService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CouponServiceTest {

    private final CouponService service = new CouponService();

    @Test
    public void testValidCoupon() {
        Coupon coupon = new Coupon();
        coupon.setActive(true);
        coupon.setDiscount(10);
        coupon.setExpiryDate(LocalDate.now().plusDays(5));

        assertTrue(service.validateCoupon(coupon));
    }

    @Test
    public void testExpiredCoupon() {
        Coupon coupon = new Coupon();
        coupon.setActive(true);
        coupon.setDiscount(10);
        coupon.setExpiryDate(LocalDate.now().minusDays(1));

        assertFalse(service.validateCoupon(coupon));
    }

    @Test
    public void testInactiveCoupon() {
        Coupon coupon = new Coupon();
        coupon.setActive(false);
        coupon.setDiscount(10);
        coupon.setExpiryDate(LocalDate.now().plusDays(5));

        assertFalse(service.validateCoupon(coupon));
    }
}