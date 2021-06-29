package de.lubowiecki.csv2pdf;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfWriter implements Writable {

	public final Path path;
	
	public PdfWriter(Path path) {
		this.path = path;
	}

	@Override
	public void write(Readable r) throws IOException {
		
		try(PDDocument doc = new PDDocument()) {
			
			PDPage page = new PDPage();
			doc.addPage(page);
			
			try(PDPageContentStream content = new PDPageContentStream(doc, page)) {
				
				content.beginText();
				content.setFont(PDType1Font.COURIER, 14);
				
				content.newLineAtOffset(20, 750);
				content.setLeading(12);
				
				try {
					List<List<String>> rows = r.read();
					
					for(List<String> row : rows) {
						content.showText(row.get(0) + ", " + row.get(1) + ", " + row.get(2));
						content.newLine();
					}
				}
				catch(Exception e) {
					throw new IOException(e.getMessage());
				}
				
				content.endText();
				
			}
			doc.save(path.toFile());
		}
	}
}
