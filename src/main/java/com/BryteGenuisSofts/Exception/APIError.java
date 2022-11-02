package com.BryteGenuisSofts.Exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
// import @Data from lombok to create all your getters,setters and constructors for you
@Data
public class APIError {

	private String message;
	private List<String> details;
	private HttpStatus status;
	private LocalDateTime time;
}
