package br.com.sdconecta.api.controller.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsResponse implements Serializable {

	private static final long serialVersionUID = 4120280971606756350L;
	private List<ErrorResponse> errors;

}
