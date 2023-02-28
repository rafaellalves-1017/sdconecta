package br.com.sdconecta.api.controller.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 3791776273631166107L;
	private Integer code;
	private String fiedlName;
	private String message;

}
