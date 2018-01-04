package com.musicinstruments.exceptions;

import com.musicinstruments.entity.Category;

public class CategoriesCircledStructureException extends RuntimeException {
	
    public CategoriesCircledStructureException() {
        super("Circled structure of categories was tried to create.");
    }
}
