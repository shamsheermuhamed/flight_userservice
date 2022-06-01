package com.shamsheer.flightapp.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecordNotFoundException extends RuntimeException {
		
		@ExceptionHandler
		public ResponseEntity<Object> exception(RecordNotFoundException ex)
		{
			return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
		}

}
