package de.lubowiecki.javakurs.strings;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TokenizerSample {

	public static void main(String[] args) {
		
		String str = "Das ist ein, Haus von Nikigraus";
		StringTokenizer tokenizer = new StringTokenizer(str);
		
		while(tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextToken());
		}
		
		
		
		
		System.out.println();
		
		Collections.list(new StringTokenizer(str)).stream()
			.collect(Collectors.toList());
	}

}
