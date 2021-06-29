package de.lubowiecki.csv2pdf;

import java.util.List;

public interface Readable {
	
	List<List<String>> read() throws Exception;

}
