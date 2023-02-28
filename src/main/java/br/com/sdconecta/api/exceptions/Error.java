package br.com.sdconecta.api.exceptions;

import static java.lang.Boolean.FALSE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;

public enum Error implements BaseApplicationError {
	
	LOGIN_NOT_FOUND_ERROR ("LOGIN-001", BAD_REQUEST, FALSE, "Login não encontrado!");

	private final String code;
	private final String description;
	private final HttpStatus httpStatus;
	private final boolean acceptParameters;
	
	private Error(String code, HttpStatus httpStatus, Boolean acceptParameters, String description) {
		this.code = code;
		this.description = description;
		this.httpStatus = httpStatus;
		this.acceptParameters = acceptParameters;
	}

	@Override
	public boolean getAcceptParameters() {
		return acceptParameters;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
