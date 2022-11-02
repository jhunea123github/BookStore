package com.BryteGenuisSofts.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.BryteGenuisSofts.Exception.BookNotFoundExceptiomn;
import com.BryteGenuisSofts.Exception.IdNotFoundExceptiomn;
import com.BryteGenuisSofts.dao.BookDAO;
import com.BryteGenuisSofts.pojo.Book;
@Service
public class BookServicesImplementation implements BookServicesInt {

	@Autowired
	private BookDAO dao;
	@Override
	public boolean addBook(Book book) {

		Book add = new Book();
		add.setTitle(book.getTitle());
		Example<Book> examp = Example.of(add);
		Optional<Book> option = dao.findOne(examp);
		
		if (option.isPresent()) {
			return true ;
		}
		return false;
		}
	

	@Override
	public List<Book> getBookCategory(String category) {
		List <Book> cate = dao.findAll()
			.stream()
			.filter(book -> book.getCategory().equals(category))
			.collect(Collectors.toList()); //collect and sends it to collector
		if(cate.isEmpty()) {
			throw new BookNotFoundExceptiomn("Category not found");
		}
		
		return cate;
	}

	@Override
	public List<Book>  getBookAuthor(String author) {
				List<Book> auth = dao.findAll()
					.stream()
					.filter(book -> book.getAuthor().equals(author))
					.collect(Collectors.toList());
				if (auth.isEmpty()) {
					throw new BookNotFoundExceptiomn("author not Found");
				}
				return auth;
	}

	@Override
	public Book getBookById(Integer id) {
		//finds all information in the database
				return dao.findById(id)
				// streams it through a pipe line
				.stream()
				//filter filters and if  the id is true then  will send to the any
				.filter(book -> book.getBookid() == id)
				// get information from the filtered list
				.findAny()
				//if not present return null or return any.
				.orElseThrow(() -> new IdNotFoundExceptiomn("ID not found"));
	}


	
}
