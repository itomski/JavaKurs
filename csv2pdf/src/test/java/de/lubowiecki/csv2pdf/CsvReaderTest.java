package de.lubowiecki.csv2pdf;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CsvReaderTest {
	
	private CsvReader reader;

	@Before
	public void setUp() throws Exception {
		reader = new CsvReader(Paths.get("data.csv"));
	}

	@Test
	public void testWhenRead_thenRow1Equals() throws Exception {
		List<String> row = Arrays.asList("A", "B", "C");
		List<List<String>> rows = reader.read();
		assertEquals(row, rows.get(0));
	}
	
	@Test
	public void testReadRow2() throws Exception {
		List<String> row = Arrays.asList("D", "E", "F");
		List<List<String>> rows = reader.read();
		assertEquals(row, rows.get(1));
	}
	
	// JUnit 5
//	@Test
//	public void testReadNoFile() {
//		Exception ex = assertThrows(IOException.class, () -> {
//			CsvReader reader = new CsvReader(Paths.get("no_data.csv"));
//			reader.read();
//		});
//		String msg = "Datei nicht vorhanden.";
//		assertTrue(ex.getMessage().contains(msg));
//	}
	
	@Test(expected = IOException.class)
	public void testReadNoFile() throws Exception {
		CsvReader reader = new CsvReader(Paths.get("no_data.csv"));
		reader.read();
	}
}
