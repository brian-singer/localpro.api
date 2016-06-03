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

import org.hibernate.validator.constraints.Email;

import at.localpro.dto.CreateLocalProReqestDTO;

public interface ILocalPro {

	public static final String V1_LOCALPROS = ILocalPro.VERSION + ILocalPro.PROS;

	static final String VERSION = "/v1/";

	static final String PROS = "localpros";
	static final String V1_SEARCH = ILocalPro.VERSION + ILocalPro.PROS + "/search";
	static final String ID = V1_LOCALPROS + "/{id}";

	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@GET
	@Path(V1_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	Object getAllPros();

	@GET
	@Path(V1_LOCALPROS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByEmail(
			@QueryParam(value = "email") @Email String email);

	@POST
	@Path(V1_LOCALPROS)
	@Consumes(MediaType.APPLICATION_JSON)
	Response add(@NotNull @Valid CreateLocalProReqestDTO localPro);

}
