package br.com.onshoes.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = {"/", "/index.html"} )
	public String index() {
		return "client/index";
	}
	
}

