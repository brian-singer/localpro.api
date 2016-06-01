package at.localpro.rest.util;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.joda.time.DateTime;

import at.localpro.dto.error.Code;
import at.localpro.dto.error.Error;
import at.localpro.rest.exception.RestException;

public abstract class RestUtil {

	public static Response createResourceCreatedResponse(String uri) {
		try {
			return Response.created(new URI(uri)).build();
		} catch (URISyntaxException e) {
			return Response.ok().build();
		}
	}

	public static void validateDateRangeQuery(DateTime start, DateTime end) throws RestException {
		if (start.isAfter(end)) {
			throw new RestException(Response.status(Status.BAD_REQUEST)
					.entity(new Error(Code.INVALID_REQUEST.getCode(), "Start date cannot be after end date")).build());
		}
		if (end.isBefore(start)) {
			throw new RestException(Response.status(Status.BAD_REQUEST)
					.entity(new Error(Code.INVALID_REQUEST.getCode(), "End date cannot be before start date")).build());
		}
	}
}
