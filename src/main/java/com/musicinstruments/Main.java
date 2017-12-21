package com.musicinstruments;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.musicinstruments.config.ApplicationContextConfig;
import com.musicinstruments.engine.ProductEngine;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		
		ProductEngine productEngine = context.getBean(ProductEngine.class);
		
		
		Category cat1 = new Category();
		cat1.setName("percursion");
		productEngine.createCategory(cat1);
		
		context.close();
	}
}
