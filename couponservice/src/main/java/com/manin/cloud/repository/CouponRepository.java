package com.manin.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manin.cloud.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
