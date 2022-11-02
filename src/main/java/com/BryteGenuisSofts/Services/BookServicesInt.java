package com.BryteGenuisSofts.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BryteGenuisSofts.Exception.BookNotFoundExceptiomn;
import com.BryteGenuisSofts.Exception.IdNotFoundExceptiomn;
import com.BryteGenuisSofts.pojo.Book;
@Service
public interface BookServicesInt {
	
	// declare function to be used in the program
	boolean addBook (Book book);
	List<Book> getBookCategory(String category) throws BookNotFoundExceptiomn;
	List<Book> getBookAuthor(String author)throws BookNotFoundExceptiomn;
	Book getBookById(Integer id)throws IdNotFoundExceptiomn;
	
	
}
