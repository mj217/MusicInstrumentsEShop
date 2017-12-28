package com.musicinstruments.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	private Category category;
	
	@Before
	public void setup() {
		category = new Category();
	}
	
	@Test
	public void testSetValidParentCategorySuccess() {
		Category subCategory = new Category();
		
		category.addSubcategory(subCategory);
		assertTrue(containsSubCategory(category, subCategory));
		assertEquals(category, subCategory.getParentCategory());
	}

	private boolean containsSubCategory(Category category2, Category subCategory) {
		return category.getSubCategories().contains(subCategory);
	}
}
