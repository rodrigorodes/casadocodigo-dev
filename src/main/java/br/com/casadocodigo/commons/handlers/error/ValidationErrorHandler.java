package br.com.casadocodigo.commons.handlers.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.casadocodigo.commons.handlers.error.model.ErrorResponse;

@RestControllerAdvice
public class ValidationErrorHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorResponse> handler(MethodArgumentNotValidException exception, WebRequest request){
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		return new CreateErrorResponseAPI(fieldErrors, messageSource).create();
	}

	private static class CreateErrorResponseAPI {
		
		private List<ErrorResponse> errors = new ArrayList<>();
		private List<FieldError> fieldErrors;
		private MessageSource messageSource;

		public CreateErrorResponseAPI(List<FieldError> fieldErrors, MessageSource messageSource) {
			this.fieldErrors = fieldErrors;
			this.messageSource = messageSource;
		}
		
		public List<ErrorResponse> create(){
			fieldErrors.forEach(fieldError -> {
				String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
				errors.add(new ErrorResponse(message, fieldError.getField(), fieldError.getRejectedValue()));
				
			});
			return errors;
		}
	}

}
