package br.com.sdconecta.api.exceptions;

import br.com.sdconecta.api.util.StringUtil;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -626829171600124554L;
	
	private final BaseApplicationError error;

    private final Object[] parameters;

    private final Object data;

    public ServiceException(BaseApplicationError error, Object... parameters) {
        super(StringUtil.formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = null;
    }

    public ServiceException(BaseApplicationError error, Throwable cause, Object... parameters) {
        super(StringUtil.formatMessage(error.getDescription(), parameters), cause);
        this.error = error;
        this.parameters = parameters;
        this.data = null;
    }

    public ServiceException(Object data, BaseApplicationError error, Object... parameters) {
        super(StringUtil.formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public ServiceException(Object data, BaseApplicationError error, Throwable cause, Object... parameters) {
        super(StringUtil.formatMessage(error.getDescription(), parameters), cause);
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public BaseApplicationError getError() {
        return error;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Object getData() {
        return data;
    }

}
