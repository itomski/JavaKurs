package de.lubowiecki.csv2pdf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements Readable {

	private Path path;
	
	public CsvReader(Path path) {
		this.path = path;
	}

	@Override
	public List<List<String>> read() throws Exception {
		
		if(!Files.exists(path))
			throw new IOException("Datei nicht vorhanden.");
		
		List<List<String>> data = Files.lines(path)
									   .map(row -> Arrays.asList(row.split(","))) // Zeilen werden in Listen von Strings zerlegt
								       .collect(Collectors.toList()); // Alle Werte in eine Liste sammeln
		
		return data;
	}
}