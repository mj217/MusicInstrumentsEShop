package com.musicinstruments.engine;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.dao.CategoryDao;
import com.musicinstruments.dao.ProductDao;
import com.musicinstruments.dao.ShoppingCartItemDao;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;
import com.musicinstruments.entity.ShoppingCartItem;

public class ProductEngine {

	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired
	private ShoppingCartItemDao shoppingCartItemDao;
	
	@Transactional
	public void createProduct(Product product) {
		productDao.persist(product);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		productDao.update(product);
	}
	
	@Transactional
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}
	
	@Transactional
	public void assignProductToCategory(Product product, Category category) {
		product.getCategories().add(category);
		category.getProducts().add(product);
		productDao.update(product);
		categoryDao.update(category);
	}
	
	@Transactional
	public void unassignProductFromCategory(Product product, Category category) {
		product.getCategories().remove(category);
		category.getProducts().remove(product);
		productDao.update(product);
		categoryDao.update(category);
	}
	
	public HashSet<Category> getProductCategories(Product product) {
		return product.getCategories();
	}
	
	public void addProductToShoppingCart(Product product, ShoppingCartItem shoppingCartItem) {
		product.getShoppingCartItems().add(shoppingCartItem);
		shoppingCartItem.setProduct(product);
		productDao.update(product);
		shoppingCartItemDao.update(shoppingCartItem);
	}
	
	public void removeProductFromShoppingCart(Product product, ShoppingCartItem shoppingCartItem) {
		product.getShoppingCartItems().remove(shoppingCartItem);
		shoppingCartItem.setProduct(product);
		productDao.update(product);
		shoppingCartItemDao.delete(shoppingCartItem);
	}
	
	public void updateShoppingCartProductQuantity(ShoppingCartItem shoppingCartItem, Integer quantity) {
		Integer currentQuantity = shoppingCartItem.getQuantity();
		shoppingCartItem.setQuantity(currentQuantity + quantity);
		shoppingCartItemDao.update(shoppingCartItem);
	}
}
