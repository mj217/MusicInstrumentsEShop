package com.musicinstruments.utils;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class CommonUtil {

	private CommonUtil() {
		
	}
	
	// Returns not null unmodifiable copy of the source set
	public static <T> Set<T> getSafeSet(Set<T> source) {
		return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
	}
}
