package com.manin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manin.cloud.model.Coupon;
import com.manin.cloud.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	private CouponRepository couponRepo;
	@RequestMapping(value="/coupons",method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
		
	}
	@RequestMapping(value="/coupons/{code}",method = RequestMethod.GET)
	public Coupon get(@PathVariable("code") String code) {
		System.out.println("Server 2");
		return couponRepo.findByCode(code);
	}

}
