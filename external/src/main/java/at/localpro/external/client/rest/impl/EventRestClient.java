package at.localpro.external.client.rest.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import at.localpro.IEvent;
import at.localpro.converter.DateTimeParamConverter;
import at.localpro.dto.event.EventDTO;
import at.localpro.dto.event.RegisterRequestDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;
import at.localpro.rest.util.RestUtil;

@WebService
@Service
public class EventRestClient implements IEvent {

	@Autowired
	private RestClient client;

	@Override
	public Object get(String eventId) {
		return client.getByUri(Request.GET_EVENT.getUri(), new ParameterizedTypeReference<EventDTO>() {
		}, eventId);
	}

	@Override
	public Object add(EventDTO localProEvent) {
		// @formatter:off
		if (localProEvent.getEventStart() == null) {
			localProEvent.setEventStart(DateTime.now());
			localProEvent.setEventEnd(DateTime.now().plusHours(24));
		}
		if (localProEvent.getEventEnd() == null) {
			localProEvent.setEventStart(DateTime.now());
			localProEvent.setEventEnd(DateTime.now().plusHours(24));
		}
		return Response.status(Status.CREATED).location(
				client.post(Request.EVENTS.getUri(), localProEvent).getLocation()).build();
		// @formatter:on
	}

	@Override
	public Object getByLocalPro(String localProId) {
		return client.getByUri(Request.GET_LOCALPRO_EVENTS.getUri(), new ParameterizedTypeReference<List<EventDTO>>() {
		}, localProId);
	}

	@Override
	public Object filter(DateTime start, DateTime end, BigDecimal latitude, BigDecimal longitude,
			Integer maxDistanceInKilometers) {
		DefaultMapEntry<String, String> startQuery = new DefaultMapEntry<>("start",
				DateTimeParamConverter.format(start));
		DefaultMapEntry<String, String> endQuery = new DefaultMapEntry<>("end", DateTimeParamConverter.format(end));
		// if (latitude == null || longitude == null || maxDistanceInKilometers
		// == null) {
		return client.query(Request.EVENTS.getUri(), Arrays.asList(startQuery, endQuery));
		// }
		// DefaultMapEntry<String, String> longitudeQuery = new
		// DefaultMapEntry<>("longitude", longitude.toString());
		// DefaultMapEntry<String, String> latitudeQuery = new
		// DefaultMapEntry<>("latitude", latitude.toString());
		// DefaultMapEntry<String, String> maxDistanceQuery = new
		// DefaultMapEntry<>("maxdistance",
		// maxDistanceInKilometers.toString());
		// return client.query(Request.EVENTS.getUri(),
		// Arrays.asList(startQuery, endQuery, longitudeQuery, latitudeQuery,
		// maxDistanceQuery));
	}

	@Override
	public Object register(String id, RegisterRequestDTO register) {
		client.put(Request.EVENT_REGISTER.getUri(), register, id);
		return RestUtil.createResourceCreatedResponse(IEvent.ID, id);
	}

}
