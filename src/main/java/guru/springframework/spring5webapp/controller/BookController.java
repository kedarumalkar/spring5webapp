/**
 * 
 */
package guru.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

/**
 * @author Kedar
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping("/books")
	public String books(Model model) {		
		model.addAttribute("books", bookRepository.findAll());		
		return "books/list";
	}
}
