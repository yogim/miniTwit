package com.ymhase.miniTwit.exception;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler  {
	
	private static final Logger logger = Logger.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Error> handleException(CustomException exception,WebRequest request) {
		logger.info("Exception occured: " + exception.getMessage());
		Error errorDetails = new Error (exception.getMessage(),
		        request.getDescription(false),(new Date()));
		    return new ResponseEntity<Error>(errorDetails, HttpStatus.NOT_FOUND);
	}


}
