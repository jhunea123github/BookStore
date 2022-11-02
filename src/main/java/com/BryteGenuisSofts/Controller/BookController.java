package com.BryteGenuisSofts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.BryteGenuisSofts.Services.BookServicesImplementation;
import com.BryteGenuisSofts.dao.BookDAO;
import com.BryteGenuisSofts.pojo.Book;

@RestController
public class BookController {
	@Autowired
	private BookServicesImplementation boo;
	@Autowired
	private BookDAO service;
	
	@PostMapping("/createbook")
	public ResponseEntity<?> addBook(@RequestBody Book book){
		//creating headers for display
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "this is to the book");
		
		boolean serviceBook = boo.addBook(book);
		if(!serviceBook) {
			service.save(book);
			return ResponseEntity.ok("Book Saved Successfully.......");
		
		}
		return ResponseEntity.status(HttpStatus.OK).body("Book with this title already exit");
		
		
	}
	//search for book using the authors name
	
	@GetMapping("/author/{author}")
	public ResponseEntity<?> getAuthor(@PathVariable("author") String author){
		List<Book> auth = boo.getBookAuthor(author);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get the author");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(auth);
		
		
	}
	
	// search through the book using the name of the Book category
	@GetMapping("/category/{category}")
	public ResponseEntity<?> getBookCategory(@PathVariable("category") String category){
		List<Book> cate = boo.getBookCategory(category);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get the category");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(cate);
		
		
	}
	// search for the book using the books id generated 
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findbookById(@PathVariable Integer id){
		// import the service sao to get access to the methods in there;
				Book Bookservice = boo.getBookById(id);
				return ResponseEntity.ok(Bookservice);
	}
	
	
}
