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
		
		ProductEngine productEngine = (ProductEngine) context.getBean("productEngine");
		
		Category cat1 = new Category();
		cat1.setName("percursion");
		productEngine.createCategory(cat1);
		Category cat2 = new Category();
		cat2.setName("wind");
		productEngine.createCategory(cat2);
		
		context.close();
	}
}
