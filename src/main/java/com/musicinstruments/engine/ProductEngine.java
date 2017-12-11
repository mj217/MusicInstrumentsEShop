package com.musicinstruments.engine;

import java.math.BigDecimal;
import java.util.HashSet;

import com.musicinstruments.dao.ProductDao;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

public class ProductEngine {

	private ProductDao productDao;
	
	public void createProduct(String name, BigDecimal price, 
			String supplier, Integer quantityInStock) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setSupplier(supplier);
		product.setQuantityInStock(quantityInStock);
		
		productDao.save(product);
	}
	
	public void updateProduct(Product product) {
		productDao.save(product);
	}
	
	public void deleteProduct(Product product) {
		productDao.deleteById(product.getId());
	}
	
	public void assignProductToCategory(Product product, Category category) {
		product.getCategories().add(category);
	}
	
	public void unassignProductFromCategory(Product product, Category category) {
		product.getCategories().remove(category);
	}
	
	public HashSet<Category> getProductCategories(Product product) {
		return product.getCategories();
	}
}
