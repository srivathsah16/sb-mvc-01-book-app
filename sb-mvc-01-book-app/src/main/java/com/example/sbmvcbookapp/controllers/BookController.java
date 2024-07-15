package com.example.sbmvcbookapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.sbmvcbookapp.entity.Book;
import com.example.sbmvcbookapp.repository.BookRepository;

@Controller
// @RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepo;

    @GetMapping("/")
    public String home() {
        return "home"; 
    }

	// APPROACH- 1
	@GetMapping("/getById")
	public ModelAndView getBookById(@RequestParam("id") Integer id) {
		System.out.println("id=" + id);
		ModelAndView mv = new ModelAndView();
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			Book bookObj = optional.get();
			System.out.println("book=" + bookObj);
			mv.addObject("book", bookObj);
		}
		mv.setViewName("index");
		return mv;
	}

	// APPROACH- 2
	@GetMapping("/book")  
	public String getBook(@RequestParam("id") Integer id, Model model) {
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			Book bookObj = optional.get();
			//adding data to model, this will be accessed in View while rendering the data.
			model.addAttribute("book", bookObj);
		}
		//directly return the view name
		return "index";
	}
	@PostMapping("/addBook")
	public String addBook(@RequestParam String bookName,@RequestParam String bookPrice, Model model) { 
		System.out.println("bookName="+bookName+",bookPrice"+bookPrice);
		Book book = new Book();
		book.setName(bookName);
		book.setPrice(Double.parseDouble(bookPrice));
		bookRepo.save(book);
		System.out.println("addBook triggered");
		model.addAttribute("message", "Book Details saved in DB succcessfully.");
		return "addBook";
	}
}
