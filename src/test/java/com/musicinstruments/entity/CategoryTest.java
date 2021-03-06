package com.musicinstruments.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.musicinstruments.exceptions.CategoriesCircledStructureException;

public class CategoryTest {
	private Category category;
	
	@Before
	public void setup() {
		category = new Category();
	}
	
	@Test
	public void testAddValidSubCategorySuccess() {
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
	public void testAddDuplicateSubCategoryFailure() {
		Category subCategory = new Category();
		
		category.addSubCategory(subCategory);
		category.addSubCategory(subCategory);	
		
		assertEquals(category.getSubCategories().size(), 1);
	}
	
	@Test
	public void testRemoveSubCategorySuccess() {
		Category subCategory = new Category();
		
		category.removeSubCategory(subCategory);

		assertTrue(category.getSubCategories().isEmpty());
	}
	
	@Test(expected=NullPointerException.class)
	public void testRemoveNullSubCategoryFailure() {
		category.removeSubCategory(null);
		fail();
	}
	
	@Test(expected=CategoriesCircledStructureException.class)
	public void testCreateCircledCategoriesStructureFailure() {

		Category subCategory1 = new Category();
		Category subCategory2 = new Category();

		category.addSubCategory(subCategory1);
		subCategory1.addSubCategory(subCategory2);
		subCategory2.addSubCategory(category);
		fail();
	}
	
	private boolean containsSubCategory(Category category, Category subCategory) {
		return category.getSubCategories().contains(subCategory);
	}
}
