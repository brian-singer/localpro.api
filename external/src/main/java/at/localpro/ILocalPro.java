package at.localpro;

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
import javax.ws.rs.core.Response;

import at.localpro.dto.CreateLocalProReqestDTO;

public interface ILocalPro {

	public static final String V1_LOCALPROS = Version.V1 + ILocalPro.PROS;

	static final String PROS = "localpros";
	static final String V1_SEARCH = Version.V1 + ILocalPro.PROS + "/search";
	static final String V1_GET_ID = Version.V1 + ILocalPro.PROS + "/id";
	static final String ID = V1_LOCALPROS + "/{id}";
	static final String SPORTS = ID +"/sports";

	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@GET
	@Path(SPORTS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getSports(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@GET
	@Path(V1_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	Object getAllPros();

	@GET
	@Path(V1_LOCALPROS)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@QueryParam(value = "email") String email,
			@QueryParam(value = "userid") String userId);

	@GET
	@Path(V1_GET_ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object getId(
			@QueryParam(value = "userid") @Size(min = 20, max = 25) String userId);

	@POST
	@Path(V1_LOCALPROS)
	@Consumes(MediaType.APPLICATION_JSON)
	Response add(@NotNull @Valid CreateLocalProReqestDTO localPro);

}
