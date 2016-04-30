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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import at.localpro.dto.error.Error;
import at.localpro.dto.event.EventListingDTO;
import at.localpro.dto.event.SingleEventDTO;

@Api(value = IEvent.V1_EVENTS)
public interface IEvent {

	public static final String V1_EVENTS = ILocalPro.VERSION + IEvent.EVENTS;

	static final String EVENTS = "events";
	public static final String ID = V1_EVENTS + "/{id}";
	static final String ID_PARAM = "/{id}/";
	static final String ID_REPLACE = "/%s/";
	static final String SLASH = "/";

	static final String V1_LOCAL_PRO_EVENTS = ILocalPro.VERSION + ILocalPro.PROS + ID_PARAM + EVENTS;
	public static final String V1_LOCAL_PRO_EVENTS_ID = ILocalPro.VERSION + ILocalPro.PROS + ID_REPLACE + EVENTS;

	// @formatter:off
	@ApiOperation(value = "Get the event by id", response = SingleEventDTO.class)
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Event not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(@PathParam(value = "id") @Size(min = 20, max = 25) String eventId);

	@ApiOperation(value = "Get all events by localpro id", response = EventListingDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:No Events found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_LOCAL_PRO_EVENTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByLocalPro(@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@ApiOperation(value = "Post an event")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Resource created"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:No Events found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@POST
	@Path(V1_EVENTS)
	@Consumes(MediaType.APPLICATION_JSON)
	Object add(@NotNull @Valid SingleEventDTO event);

	@ApiOperation(value = "Get the events by date query filter and optional location filter", response = EventListingDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:No Events found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_EVENTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object filter(@QueryParam(value = "start") @NotNull DateTime start, @QueryParam(value = "end") DateTime end,
			@QueryParam(value = "latitude") BigDecimal latitude, @QueryParam(value = "longitude") BigDecimal longitude,
			@QueryParam(value = "maxdistance") Integer maxDistanceInKilometers);

}
