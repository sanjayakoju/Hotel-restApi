package com.hotelapp.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hotelapp.models.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method not supported");
		ApiErrors errors = new ApiErrors(message, details, status, LocalDateTime.now());
		
		return new ResponseEntity<> (errors, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type - Not Supported");
		ApiErrors errors = new ApiErrors(message, details, status, LocalDateTime.now());
		
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path varibale is missing");
		details.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(message, details, status, LocalDateTime.now());
		
		return ResponseEntity.status(status).body(errors);
	}

	

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Mismatch of Type");
		ApiErrors errors = new ApiErrors(message, details, status, LocalDateTime.now());
		
		return ResponseEntity.status(status).body(errors);
	}

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException ex, final  HttpServletRequest request)
	{
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Hotel not found!!!");
		ApiErrors errors = new ApiErrors(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		
		return new ResponseEntity<> (errors, HttpStatus.BAD_REQUEST);
	}

//  Another way of handling Exception
	
//	@ExceptionHandler(HotelNotFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public @ResponseBody ApiErrors handleResourceNotFound(final HotelNotFoundException exception,
//			final HttpServletRequest request) {
//		String message = exception.getMessage();
//		List<String> details = new ArrayList<>();
//		details.add("Mismatch of Type");
//		ApiErrors errors = new ApiErrors(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
//		System.out.println(errors);
//		return errors;
//	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex)
	{
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Invalid Id");
		ApiErrors errors = new ApiErrors(message, details ,HttpStatus.NOT_FOUND ,LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
	
}
