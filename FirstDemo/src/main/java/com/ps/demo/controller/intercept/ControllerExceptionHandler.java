package com.ps.demo.controller.intercept;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ps.demo.exception.UserInvalidException;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(UserInvalidException.class)
	@ResponseBody
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleUserInvalidException(UserInvalidException ex){
		System.out.println("Handler began....");
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("userId", ex.getUserId());
		resultMap.put("message", ex.getMessage());
		return resultMap;
	}
}
