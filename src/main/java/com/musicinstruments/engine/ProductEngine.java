package com.musicinstruments.engine;

import java.math.BigDecimal;
import java.util.HashSet;

import com.musicinstruments.dao.ProductDao;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

public class ProductEngine {

	private ProductDao productDao;
	
	public void createProduct(Product product) {
		productDao.persist(product);
	}
	
	public void updateProduct(Product product) {
		productDao.update(product);
	}
	
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}
	
	public void assignProductToCategory(Product product, Category category) {
		productDao.findById(product.getId());
	}
	
	public void unassignProductFromCategory(Product product, Category category) {
		product.getCategories().remove(category);
	}
	
	public HashSet<Category> getProductCategories(Product product) {
		return product.getCategories();
	}
}
