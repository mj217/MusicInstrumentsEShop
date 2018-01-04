package com.musicinstruments.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	
	@Before
	public void setup() {
		order = new Order();
	}
	
	@Test
	public void testSetValidDeliveryDateSuccess() {
		order.setDeliveryDate(LocalDate.now().plusDays(1));
		assertTrue(order.getDeliveryDate().isAfter(LocalDate.now()));
	}
}
