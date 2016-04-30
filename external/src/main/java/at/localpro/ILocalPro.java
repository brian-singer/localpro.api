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

import org.hibernate.validator.constraints.Email;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import at.localpro.dto.LocalProDTO;

@Api(value = ILocalPro.V1_LOCALPROS)
public interface ILocalPro {

	public static final String V1_LOCALPROS = ILocalPro.VERSION + ILocalPro.PROS;

	static final String VERSION = "/v1/";

	static final String PROS = "localpros";
	static final String V1_SEARCH = ILocalPro.VERSION + ILocalPro.PROS + "/search";
	static final String ID = V1_LOCALPROS + "/{id}";

	// @formatter:off
	@ApiOperation(value = "Get the localpro by id", response = LocalProDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Pro not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@ApiOperation(value = "Search localpros", response = LocalProDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:None found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	Object getAllPros();

	@ApiOperation(value = "Get the localpro by email", response = LocalProDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Event not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_LOCALPROS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByEmail(
			@QueryParam(value = "email") @Email String email);

	@ApiOperation(value = "Post a localpro to the Community!")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Resource created"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@POST
	@Path(V1_LOCALPROS)
	@Consumes(MediaType.APPLICATION_JSON)
	Object add(@NotNull @Valid LocalProDTO localPro);

}
