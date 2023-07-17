package com.user.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.exceptions.DuplicateRecordException;
import com.user.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvaliArgument(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleLogic(UserNotFoundException ex){
		Map<String,String> map = new HashMap<>();
		map.put("error", ex.getMessage());
		return map;
	}
	@ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<String> handleDuplicateRecordException(DuplicateRecordException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	
}
}
