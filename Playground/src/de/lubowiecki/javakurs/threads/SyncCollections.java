package de.lubowiecki.javakurs.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SyncCollections {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		List<Integer> syncList = Collections.synchronizedList(list); // Ein threadsicherer Wrapper
	
	}

}
