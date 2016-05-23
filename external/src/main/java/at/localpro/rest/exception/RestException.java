package at.localpro.rest.exception;

import javax.ws.rs.core.Response;

public class RestException extends Exception {

	private static final long serialVersionUID = 7221417526574359287L;

	private Response response;

	public RestException(Response response) {
		super();
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}
}
