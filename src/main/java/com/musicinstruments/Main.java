package com.musicinstruments;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.musicinstruments.config.ApplicationContextConfig;
import com.musicinstruments.engine.OrderEngine;
import com.musicinstruments.engine.ProductEngine;
import com.musicinstruments.engine.UserEngine;
import com.musicinstruments.entity.Category;
import com.musicinstruments.entity.Product;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		
		ProductEngine productEngine = (ProductEngine) context.getBean("productEngine");
		OrderEngine orderEngine = (OrderEngine) context.getBean("orderEngine");
		UserEngine userEngine = (UserEngine) context.getBean("userEngine");
		
		Category cat1 = productEngine.getCategoryDao().findByName("string");
		Category cat2 = productEngine.getCategoryDao().findByName("percursion");
		Category cat3 = productEngine.getCategoryDao().findByName("wind");
		productEngine.assignParentCategory(cat3, cat1);

		
		context.close();
	}
}
