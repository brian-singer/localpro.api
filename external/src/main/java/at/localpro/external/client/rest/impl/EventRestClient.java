package at.localpro.external.client.rest.impl;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.localpro.IEvent;
import at.localpro.dto.event.EventDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;

@WebService
@Service
public class EventRestClient implements IEvent {

	@Autowired
	private RestClient client;

	private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@Override
	public Object get(String eventId) {
		return client.getByUri(Request.GET_EVENT.getUri(), eventId);
	}

	@Override
	public Object add(EventDTO localProEvent) {
		// @formatter:off
		return Response.status(Status.CREATED).location(
				client.post(Request.EVENTS.getUri(), localProEvent)).build();
		// @formatter:on
	}

	@Override
	public Object getByLocalPro(String localProId) {
		return client.getByUri(Request.GET_LOCAL_PRO_EVENTS.getUri(), localProId);
	}

	@Override
	public Object filter(DateTime start, DateTime end, BigDecimal latitude, BigDecimal longitude,
			Integer maxDistanceInKilometers) {
		DefaultMapEntry<String, String> startQuery = new DefaultMapEntry<>("start", FORMATTER.print(start));
		DefaultMapEntry<String, String> endQuery = new DefaultMapEntry<>("end", FORMATTER.print(end));
		if (latitude == null || longitude == null || maxDistanceInKilometers == null) {
			return client.query(Request.EVENTS.getUri(), Arrays.asList(startQuery, endQuery));
		}
		DefaultMapEntry<String, String> longitudeQuery = new DefaultMapEntry<>("longitude", longitude.toString());
		DefaultMapEntry<String, String> latitudeQuery = new DefaultMapEntry<>("latitude", latitude.toString());
		DefaultMapEntry<String, String> maxDistanceQuery = new DefaultMapEntry<>("maxdistance",
				maxDistanceInKilometers.toString());
		return client.query(Request.EVENTS.getUri(), Arrays.asList(startQuery, endQuery, longitudeQuery, latitudeQuery, maxDistanceQuery));
	}

}
