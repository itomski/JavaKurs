package de.lubowiecki.csv2pdf;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class PdfWriterTest {
	
	private PdfWriter writer;
	
	@Before
	public void setUp() throws Exception {
		writer = new PdfWriter(Paths.get("test.pdf"));
	}

	@Test(expected = IOException.class)
	public void testWrite() throws IOException {
		writer.write(new CsvReader(Paths.get("_data.csv")));
	}
	
	@Test
	public void testWrite_fileExists() throws IOException {
		writer.write(new CsvReader(Paths.get("data.csv")));
		Path p = Paths.get("test.pdf");
		assertTrue(Files.exists(p));
	}
}
