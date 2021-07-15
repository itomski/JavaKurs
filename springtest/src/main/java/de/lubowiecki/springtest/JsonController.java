package de.lubowiecki.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.lubowiecki.springtest.model.Product;
import de.lubowiecki.springtest.model.ProductRepository;

@RestController
public class JsonController {
	
	@Autowired
	private ProductRepository repo;
	
	@RequestMapping(value = "/api/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Product> allProducts() {
		return repo.findAll();
	}
	
}
