package at.localpro.rest.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.Validate;

public class WebServiceResponseBuilder {

	private ResponseBuilder responseBuilder;

	private at.localpro.dto.error.Error errorResponse;

	public static WebServiceResponseBuilder internalServerError() {
		return createInternalResponseBuilder(newInstance(), Status.INTERNAL_SERVER_ERROR);
	}

	public static WebServiceResponseBuilder badRequest() {
		return createInternalResponseBuilder(newInstance(), Status.BAD_REQUEST);
	}

	public static WebServiceResponseBuilder status(int status) {
		Validate.validState(status != 0);
		return createInternalResponseBuilder(newInstance(), status);
	}

	public static WebServiceResponseBuilder status(Response.Status status) {
		Validate.notNull(status);
		return createInternalResponseBuilder(newInstance(), status);
	}

	private static WebServiceResponseBuilder createInternalResponseBuilder(WebServiceResponseBuilder builder,
			int status) {
		builder.responseBuilder = Response.status(status).type(MediaType.APPLICATION_JSON);
		return builder;
	}

	private static WebServiceResponseBuilder createInternalResponseBuilder(WebServiceResponseBuilder builder,
			Status status) {
		builder.responseBuilder = Response.status(status).type(MediaType.APPLICATION_JSON);
		return builder;
	}

	protected static WebServiceResponseBuilder newInstance() {
		return new WebServiceResponseBuilder();
	}

	public WebServiceResponseBuilder errorCause(Throwable errorCause) {
		Validate.notNull(errorCause);
		createErrorResponseIfNeeded().setDetail(errorCause.getMessage());
		return this;
	}

	public WebServiceResponseBuilder errorCode(Integer code) {
		Validate.notNull(code);
		createErrorResponseIfNeeded().setCode(code);
		return this;
	}

	public WebServiceResponseBuilder errorCause(String errorCause) {
		Validate.notNull(errorCause);
		createErrorResponseIfNeeded().setDetail(errorCause);
		return this;
	}

	public WebServiceResponseBuilder type(MediaType mediaType) {
		Validate.notNull(mediaType);
		responseBuilder.type(mediaType);
		return this;
	}

	public Response build() {
		return responseBuilder.build();
	}

	private at.localpro.dto.error.Error createErrorResponseIfNeeded() {
		if (null == errorResponse) {
			errorResponse = new at.localpro.dto.error.Error();
			responseBuilder.entity(errorResponse);
		}

		return errorResponse;
	}

}
