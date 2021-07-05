package de.lubowiecki.javakurs.streams;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

public class ParallelStreams1Test {

	ParallelStreams1 obj;
	
	@Before
	public void setUp() throws Exception {
		obj = new ParallelStreams1();
	}
	
	@Test
	public void testParallel() {
		Instant start = Instant.now();
		boolean result = obj.parallel();
		Instant end = Instant.now();
		//System.out.println("P" + Duration.between(start, end).toMillis() + "ms");
		assertTrue(result);
	}

	@Test
	public void testNonParallel() {
		Instant start = Instant.now();
		boolean result = obj.noneParallel();
		Instant end = Instant.now();
		//System.out.println("NP" + Duration.between(start, end).toMillis() + "ms");
		assertTrue(result);
	}
	
	@Test
	public void testReduce() {
		String erwartet = "ABCDEFGHIJ";
		String result = obj.reduce();
		assertEquals(erwartet, result);
	}
	
	@Test
	public void testParallelReduce() {
		String erwartet = "ABCDEFGHIJ";
		String result = obj.parallelReduce();
		assertEquals(erwartet, result);
	}
	
	
//	@Test
//	public void testForEach() {
//		obj.forEach();
//		fail();
//	}
	
//	@Test
//	public void testForEachOrderd() {
//		obj.forEachOrderd();
//		fail();
//	}
}
