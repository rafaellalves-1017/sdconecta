package br.com.sdconecta.api.exceptions;

import org.springframework.http.HttpStatus;

public interface BaseApplicationError extends BaseError {

    HttpStatus getHttpStatus();

}
