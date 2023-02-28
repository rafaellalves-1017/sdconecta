package br.com.sdconecta.api.exceptions;

public interface BaseError {

	String getCode();

    String getDescription();

    boolean getAcceptParameters();

    default boolean disableStackTraceLog() {
        return false;
    }
    
}
