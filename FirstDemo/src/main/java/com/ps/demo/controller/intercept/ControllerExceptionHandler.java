package com.ps.demo.controller.intercept;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ps.demo.exception.UserInvalidException;

@RestControllerAdvice
//@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(UserInvalidException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	//@ResponseBody
	public Map<String, Object> handleUserInvalidException(UserInvalidException ex){
		System.out.println("Handler began....");
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("userId", ex.getUserId());
		resultMap.put("message", ex.getMessage());
		return resultMap;
	}
}
