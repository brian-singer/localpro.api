package at.localpro;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import at.localpro.dto.event.EventDTO;
import at.localpro.dto.event.RegisterRequestDTO;

public interface IEvent {

	public static final String V1_EVENTS = Version.V1 + IEvent.EVENTS;

	static final String EVENTS = "events";
	public static final String ID = V1_EVENTS + "/{id}";
	public static final String REGISTER = ID + "/register";
	public static final String LEAVE = ID + "/leave";
	public static final String QUERY_EVENTS = V1_EVENTS + "?start={start}&end={end}";
	static final String ID_PARAM = "/{id}/";
	static final String ID_REPLACE = "/%s/";
	static final String SLASH = "/";

	static final String V1_LOCAL_PRO_EVENTS = Version.V1 + ILocalPro.PROS + ID_PARAM + EVENTS;
	public static final String V1_LOCAL_PRO_EVENTS_ID = Version.V1 + ILocalPro.PROS + ID_REPLACE + EVENTS;

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

	@PUT
	@Path(REGISTER)
	@Consumes(MediaType.APPLICATION_JSON)
	Object register(@PathParam("id") String id, @NotNull @Valid RegisterRequestDTO register);

	@PUT
	@Path(LEAVE)
	@Consumes(MediaType.APPLICATION_JSON)
	Object leave(@PathParam("id") String id, @NotNull @Valid RegisterRequestDTO register);

	@GET
	@Path(V1_EVENTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object filter(@QueryParam(value = "start") @NotNull DateTime start, @QueryParam(value = "end") DateTime end,
			@QueryParam(value = "latitude") BigDecimal latitude, @QueryParam(value = "longitude") BigDecimal longitude,
			@QueryParam(value = "maxdistance") Integer maxDistanceInKilometers);

}
