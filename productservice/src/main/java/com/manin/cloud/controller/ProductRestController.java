package com.manin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manin.cloud.model.Coupon;
import com.manin.cloud.model.Product;
import com.manin.cloud.repository.ProductRepository;
import com.manin.cloud.restclient.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductRestController {
	@Autowired
	CouponClient client;
	
	@Value("${com.manin.springcloud.prop}")
	private String prop;
	
	@Autowired
	private ProductRepository productRepository;
	@RequestMapping(value = "/products",method = RequestMethod.POST)
	@Retry(name="product-api",fallbackMethod = "handleError")
	public Product create(@RequestBody Product product) {
		Coupon coupon = client.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);
	}
	@RequestMapping(value="/prop",method = RequestMethod.GET)
	public String getProp() {
		return this.prop;
	}
	
	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside handle error");
		return product;
	}
}
