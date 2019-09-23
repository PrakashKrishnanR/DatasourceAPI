package com.library.landPage.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.landPage.Entity.Books;

@Controller
public class WebController {
	
	@RequestMapping("/")
	public String viewHomePage() {
		
		return "index";
	}
	
	@GetMapping("/listall")
	public String getBooks(Model model)
	{
		System.out.println("Inside getBooks method");
	    final String uri = "http://listbooks-wihm.us-e2.cloudhub.io/listBooks";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    String result = restTemplate.getForObject(uri, String.class );
	    System.out.println(result);
	    ObjectMapper mapper = new ObjectMapper();
	    List<Books> books = null;
	    
	    try {
			books = mapper.readValue(result, new TypeReference<List<Books>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Books   : "+books);
	    
	    model.addAttribute("booksList", books);
	     return "booksList";
	}

}
