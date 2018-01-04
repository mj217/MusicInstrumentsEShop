package com.musicinstruments.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrderItemTest {

	private OrderItem orderItem;
	
	@Before
	public void setup() {
		orderItem = new OrderItem();
	}
	
	@Test
	public void testSetValidQuantitySuccess() {
		orderItem.setQuantity(1);
		assertTrue(orderItem.getQuantity().compareTo(Integer.valueOf(0)) > 0);
	}
	
	@Test
	public void testSetValidPriceSuccess() {
		orderItem.setPrice(BigDecimal.valueOf(0.01));
		assertTrue(orderItem.getPrice().compareTo(BigDecimal.ZERO) > 0);
	}
}
