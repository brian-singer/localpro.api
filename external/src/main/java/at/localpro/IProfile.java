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
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import at.localpro.dto.profile.DetailRequestDTO;
import at.localpro.dto.profile.ProfileDTO;
import at.localpro.dto.profile.ProfileRequestDTO;

@Api(value = IProfile.V1_PROFILE)
public interface IProfile {

	public static final String V1_PROFILE = ILocalPro.VERSION + ILocalPro.PROS;
	static final String ID_PARAM = "/{id}/";
	static final String PROFILE = "profile";
	static final String SLASH = "/";
	static final String DETAILS = "details";

	public static final String V1_LOCALPRO_PROFILE = V1_PROFILE + ID_PARAM + PROFILE;
	public static final String V1_LOCALPRO_DETAILS = V1_LOCALPRO_PROFILE + SLASH + DETAILS;

	// @formatter:off
	@ApiOperation(value = "Get the localpro profile by id", response = ProfileDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Profile not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_LOCALPRO_PROFILE)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@ApiOperation(value = "Post a profile")
	@ApiResponses({
		@ApiResponse(code = 201, message = "resource created"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Existing localpro not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@POST
	@Path(V1_LOCALPRO_PROFILE)
	@Consumes(MediaType.APPLICATION_JSON)
	Object addProfile(
		@PathParam(value = "id") @Size(min = 20, max = 25) String localProId,
		@NotNull @Valid ProfileRequestDTO profile);

	@ApiOperation(value = "Post a profile detail")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Existing profile not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@POST
	@Path(V1_LOCALPRO_DETAILS)
	@Consumes(MediaType.APPLICATION_JSON)
	Object addProfileDetail(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId,
			@NotNull @Valid DetailRequestDTO detail);
}
