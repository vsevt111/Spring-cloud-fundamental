package com.manin.cloud.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manin.cloud.model.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
	
//	@GetMapping("couponapi/coupons/{code}")
//	Coupon getCoupon(@PathVariable("code") String code);
	
	//to test resilience4j (handle error gracefully)
	@GetMapping("couponap/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
