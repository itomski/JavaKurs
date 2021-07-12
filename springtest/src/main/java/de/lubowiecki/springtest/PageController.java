package de.lubowiecki.springtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import de.lubowiecki.springtest.model.Product;

@Controller
public class PageController {
	
	// URL unter der dise Methode verfügbar ist: http://localhost:8080/test
	@RequestMapping("/")
	public String homeAction(Model model) { // model = Template-Objekt
		model.addAttribute("title", "Startseite");
		model.addAttribute("nav", "home");
		return "standard"; // Name des Templates
	}
	
	@RequestMapping("/products")
	public String productsAction(Model model) {
		model.addAttribute("title", "Unsere Produkte");
		model.addAttribute("nav", "products");
		
		List<Product> produkte = new ArrayList<>();
		produkte.add(new Product("Super BUHA", "Top Buchhaltungs Software", 100.99));
		produkte.add(new Product("TopTimer", "Software für die Zeiterfassung", 29.99));
		produkte.add(new Product("RechnungFix", "Schnell Rechnungen erstellen", 29.99));
		
		model.addAttribute("produkte", produkte);
		return "standard"; // Name des Templates
	}
	
	@RequestMapping("/services")
	public String serviceAction(Model model) {
		model.addAttribute("title", "Unsere Services");
		model.addAttribute("nav", "service");
		return "standard"; // Name des Templates
	}
	
	@RequestMapping("/team")
	public String teamAction(Model model) {
		model.addAttribute("title", "Das Team");
		model.addAttribute("nav", "team");
		return "standard"; // Name des Templates
	}
	
	@RequestMapping("/contact")
	public String contactAction(Model model) {
		model.addAttribute("title", "Schreiben Sie uns");
		model.addAttribute("nav", "contact");
		return "standard"; // Name des Templates
	}
}
