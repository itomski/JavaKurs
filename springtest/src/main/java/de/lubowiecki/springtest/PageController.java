package de.lubowiecki.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	// URL unter der dise Methode verfügbar ist: http://localhost:8080/test
	@RequestMapping("/test")
	public String machWas() {
		return "standard"; // Name des Templates
	}
}
