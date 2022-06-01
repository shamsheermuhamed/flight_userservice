package com.shamsheer.flightapp.userservice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Discount {

	private Integer couponid;
	private String couponcode;
	private Double discountamount;
	
	public Discount()
	{
		
	}
	public Discount(Integer couponid, String couponcode, Double discountamount) {
		
		this.couponid = couponid;
		this.couponcode = couponcode;
		this.discountamount = discountamount;
	}
	public Integer getCouponid() {
		return couponid;
	}
	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}
	public String getCouponcode() {
		return couponcode;
	}
	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}
	public Double getDiscountamount() {
		return discountamount;
	}
	public void setDiscountamount(Double discountamount) {
		this.discountamount = discountamount;
	}
		
}
