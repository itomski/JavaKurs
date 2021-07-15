package de.lubowiecki.springtest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import de.lubowiecki.springtest.model.Product;
import de.lubowiecki.springtest.model.ProductRepository;

@Controller
public class PageController {
	
	@Autowired // Autowired stellt automatisch ein ProductRepository bereit
	private ProductRepository repo;
	
	// URL unter der dise Methode verfügbar ist: http://localhost:8080/test
	@RequestMapping("/")
	public String homeAction(Model model) { // model = Template-Objekt
		model.addAttribute("title", "Startseite");
		model.addAttribute("nav", "home");
		return "standard"; // Name des Templates
	}
	
	@RequestMapping("/new")
	public String productFormAction(Product product, Model model) {
		model.addAttribute("title", "Neues Produkt");
		model.addAttribute("nav", "new");
		model.addAttribute("produkt", product);
		return "standard";
	}
	
	@PostMapping("/add")
	public String addProductAction(Product product, Model model) {
		repo.save(product);
		return productsAction(model);
	}
	
	@GetMapping("/delete/{id}")
	public String removeProductAction(@PathVariable("id") int id, Model model) {
		repo.deleteById(id);
		return productsAction(model);
	}
	
	@GetMapping("/edit/{id}")
	public String editProductAction(@PathVariable("id") int id, Model model) {
		Optional<Product> optProduct = repo.findById(id);
		if(optProduct.isPresent()) {
			model.addAttribute("nav", "new");
			model.addAttribute("produkt", optProduct.get());
			return "standard";
		}
		// TODO: Produkt nicht gefunden als Meldung ausgeben
		return productsAction(model);
	}
	
	@RequestMapping("/products")
	public String productsAction(Model model) {
		model.addAttribute("title", "Unsere Produkte");
		model.addAttribute("nav", "products");
		model.addAttribute("produkte", repo.findAll());
		return "standard";
	}
	
	@RequestMapping("/services")
	public String serviceAction(Model model) {
		model.addAttribute("title", "Unsere Services");
		model.addAttribute("nav", "service");
		return "standard";
	}
	
	@RequestMapping("/team")
	public String teamAction(Model model) {
		model.addAttribute("title", "Das Team");
		model.addAttribute("nav", "team");
		return "standard";
	}
	
	@RequestMapping("/contact")
	public String contactAction(Model model) {
		model.addAttribute("title", "Schreiben Sie uns");
		model.addAttribute("nav", "contact");
		return "standard";
	}
}
