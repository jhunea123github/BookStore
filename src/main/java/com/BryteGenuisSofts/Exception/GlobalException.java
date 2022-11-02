package com.BryteGenuisSofts.Exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Please your request message is wrong");
		APIError error = new APIError(message,details,status,LocalDateTime.now());

		return	ResponseEntity.status(status).body(error);			
				
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type no Supported.....".concat("Please re-enter"));
		APIError error = new APIError(message,details,status,LocalDateTime.now());
		
		return	ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type no Supported.....".concat("Please re-enter"));
		APIError error = new APIError(message,details,status,LocalDateTime.now());
		
		return	ResponseEntity.status(status).body(error);
	}

//	@Override
//	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		String message = ex.getMessage();
//		List<String> details = new ArrayList<>();
//		details.add("Missing Path Vriables.....".concat("please check your input"));
//		APIError error = new APIError(message,details,status,LocalDateTime.now());
//		
//		return	ResponseEntity.status(status).body(error);

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Wrong Parameter Entered.....".concat("Please do a re-entry"));
		APIError error = new APIError(message,details,status,LocalDateTime.now());
		
		return	ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Types Mismatch.....".concat("Please re-enter"));
		APIError error = new APIError(message,details,status,LocalDateTime.now());
		
		return	ResponseEntity.status(status).body(error);
	}

		
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check if Requests are the same..ie Post for Update and Save.....");
		details.add("delete for deleting entry, get for Accessing information.....");

		APIError error = new APIError(message,details,status,LocalDateTime.now());
		
		return	ResponseEntity.status(status).body(error);
	}
	@ExceptionHandler(BookNotFoundExceptiomn.class)
	protected ResponseEntity<Object> handleBookNotFoundExceptiomn (BookNotFoundExceptiomn ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Book Not Found.....".concat("Please change or Retype the book name"));
		APIError error = new APIError(message,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	// creating an exception book id
	@ExceptionHandler(IdNotFoundExceptiomn.class)
	protected ResponseEntity<Object> handleIdNotFoundExceptiomn (IdNotFoundExceptiomn ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Book ID not Found....".concat("Please change check id"));
		APIError error = new APIError(message,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	// creating an exception book id
	// this is the kind exception which handles all which where not thrown and customize
	@ExceptionHandler(Exception.class)
		protected ResponseEntity<Object> handleExceptiomn (Exception ex) {
			String message = ex.getMessage();
			List<String> details = new ArrayList<>();
			details.add("Exception Occurred....".concat("please check your entries"));
			APIError error = new APIError(message,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
			
			return	ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
}
