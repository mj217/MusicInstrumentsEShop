package com.musicinstruments.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
		
		category.addSubCategory(subCategory);
		assertTrue(containsSubCategory(category, subCategory));
		assertEquals(category, subCategory.getParentCategory());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddNullSubCategoryFailure() {
		category.addSubCategory(null);
		fail();
	}
	
	@Test
	public void addDuplicateSubCategoryFailure() {
		Category subCategory = new Category();
		
		category.addSubCategory(subCategory);
		category.addSubCategory(subCategory);	
		assertEquals(category.getSubCategories().size(), 1);
	}

	private boolean containsSubCategory(Category category2, Category subCategory) {
		return category.getSubCategories().contains(subCategory);
	}
}
