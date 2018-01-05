package com.musicinstruments.engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicinstruments.dao.CategoryDao;
import com.musicinstruments.dao.Dao;
import com.musicinstruments.dao.ProductDao;
import com.musicinstruments.dao.ShoppingCartItemDao;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;
import com.musicinstruments.entity.ShoppingCartItem;

@Service
public class ProductEngine {

	private static ProductEngine instance;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired
	private ShoppingCartItemDao shoppingCartItemDao;
	
	public ProductEngine() {
		
	}
	
	public static ProductEngine getInstance() {
		if (instance == null) {
			return new ProductEngine();
		}
		
		return instance;
	}
	
	public void setproductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	public void setShoppingCartItemDao(ShoppingCartItemDao shoppingCartItemDao) {
		this.shoppingCartItemDao = shoppingCartItemDao;
	}
	
	public ShoppingCartItemDao getShoppingCartItemDao() {
		return shoppingCartItemDao;
	}
	
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
	
	public Set<Category> getProductCategories(Product product) {
		return product.getCategories();
	}
	
	@Transactional
	public void addProductToShoppingCart(Product product, ShoppingCartItem shoppingCartItem) {
		product.getShoppingCartItems().add(shoppingCartItem);
		shoppingCartItem.setProduct(product);
		productDao.update(product);
		shoppingCartItemDao.update(shoppingCartItem);
	}
	
	@Transactional
	public void removeProductFromShoppingCart(Product product, ShoppingCartItem shoppingCartItem) {
		product.getShoppingCartItems().remove(shoppingCartItem);
		shoppingCartItem.setProduct(null);
		productDao.update(product);
		shoppingCartItemDao.delete(shoppingCartItem);
	}
	
	@Transactional
	public void updateShoppingCartProductQuantity(ShoppingCartItem shoppingCartItem, Integer quantity) {
		Integer currentQuantity = shoppingCartItem.getQuantity();
		shoppingCartItem.setQuantity(currentQuantity + quantity);
		shoppingCartItemDao.update(shoppingCartItem);
	}
	
	@Transactional
	public void createCategory(Category category) {
		categoryDao.persist(category);
	}
	
	@Transactional
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}
	
	@Transactional
	public void deleteCategory(Category category) {
		categoryDao.delete(category);
	}
	
	@Transactional
	public void assignParentCategory(Category category, Category parentCategory) {
		parentCategory.addSubCategory(category);
		categoryDao.update(category);
		categoryDao.update(parentCategory);
	}

}
