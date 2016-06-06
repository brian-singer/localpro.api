package at.localpro;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import at.localpro.dto.event.EventDTO;

public interface IEvent {

	public static final String V1_EVENTS = ILocalPro.VERSION + IEvent.EVENTS;

	static final String EVENTS = "events";
	public static final String ID = V1_EVENTS + "/{id}";
	public static final String QUERY_EVENTS = V1_EVENTS + "?start={start}&end={end}";
	static final String ID_PARAM = "/{id}/";
	static final String ID_REPLACE = "/%s/";
	static final String SLASH = "/";

	static final String V1_LOCAL_PRO_EVENTS = ILocalPro.VERSION + ILocalPro.PROS + ID_PARAM + EVENTS;
	public static final String V1_LOCAL_PRO_EVENTS_ID = ILocalPro.VERSION + ILocalPro.PROS + ID_REPLACE + EVENTS;

	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(@PathParam(value = "id") @Size(min = 20, max = 25) String eventId);

	@GET
	@Path(V1_LOCAL_PRO_EVENTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByLocalPro(@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@POST
	@Path(V1_EVENTS)
	@Consumes(MediaType.APPLICATION_JSON)
	Object add(@NotNull @Valid EventDTO event);

	@GET
	@Path(V1_EVENTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object filter(@QueryParam(value = "start") @NotNull DateTime start, @QueryParam(value = "end") DateTime end,
			@QueryParam(value = "latitude") BigDecimal latitude, @QueryParam(value = "longitude") BigDecimal longitude,
			@QueryParam(value = "maxdistance") Integer maxDistanceInKilometers);

}
