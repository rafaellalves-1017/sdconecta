package br.com.sdconecta.api.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import br.com.sdconecta.api.controller.response.ErrorResponse;
import br.com.sdconecta.api.controller.response.ErrorsResponse;

@ControllerAdvice
public class ApiException {

	private static final String INTERNAL_SERVER_ERROR_TEXT = "Erro interno no servidor!";
	private static final String NOT_FOUND_TEXT = "Nenhum dado encontrado para a requisição!";
	private static final String FORBIDDEN_TEXT = "Requisição recebida, mas não autorizada a resposta!";
	private static final String UNAUTHORIZED_TEXT = "Requisição não autorizada!";

	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> serviceException(ServiceException ex) {
		return ResponseEntity.badRequest().body(ErrorsResponse.builder()
				.errors(Arrays.asList(ErrorResponse.builder()
						.code(HttpStatus.BAD_REQUEST.value())
						.message(ex.getMessage())
						.build()))
				.build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorResponse> badrequest(MethodArgumentNotValidException ex) {
		List<ErrorResponse> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			Integer code = Integer.valueOf(error.getCode());
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.add(new ErrorResponse(code, fieldName, message));
		});
		return errors;
	}
	
	@ExceptionHandler(HttpClientErrorException.Unauthorized.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<?> unauthorized(HttpClientErrorException.Unauthorized ex, WebRequest request) {
		return ResponseEntity.badRequest().body(ErrorsResponse.builder()
				.errors(Arrays.asList(ErrorResponse.builder()
						.code(HttpStatus.UNAUTHORIZED.value())
						.message(UNAUTHORIZED_TEXT)
						.build()))
				.build());
	}
	
	@ExceptionHandler(HttpClientErrorException.Forbidden.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity<?> Forbidden(HttpClientErrorException.Forbidden ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(ErrorsResponse.builder()
				.errors(Arrays.asList(ErrorResponse.builder()
						.code(HttpStatus.FORBIDDEN.value())
						.message(FORBIDDEN_TEXT)
						.build()))
				.build());
	}
	
	@ExceptionHandler(HttpClientErrorException.NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> notFound(HttpClientErrorException.NotFound ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(ErrorsResponse.builder()
				.errors(Arrays.asList(ErrorResponse.builder()
						.code(HttpStatus.NOT_FOUND.value())
						.message(NOT_FOUND_TEXT)
						.build()))
				.build());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> Forbidden(Exception ex, WebRequest request) {
		return ResponseEntity.internalServerError().body(ErrorsResponse.builder()
				.errors(Arrays.asList(ErrorResponse.builder()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.message(INTERNAL_SERVER_ERROR_TEXT)
						.build()))
				.build());
	}

    
}
