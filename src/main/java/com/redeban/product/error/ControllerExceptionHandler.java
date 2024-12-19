package com.redeban.product.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.redeban.product.error.ErrorMessageFactory.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage illegalArgumentException(Exception exception) {
		LOG.error("Error api", exception);
		return ErrorMessageFactory.get(exception);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage methodArgumentNotValidException(Exception exception) {
		LOG.error("Error validation", exception);
		return ErrorMessageFactory.get(exception);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMessage externalException(Exception exception) {
		LOG.error("Error caught", exception);
		return ErrorMessageFactory.get(exception);
	}

}
