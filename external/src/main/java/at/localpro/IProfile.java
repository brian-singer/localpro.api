package at.localpro;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.localpro.dto.profile.CreateDetailRequestDTO;
import at.localpro.dto.profile.CreateProfileRequestDTO;
import at.localpro.dto.profile.ProfileDTO;

public interface IProfile {

	public static final String V1_PROFILE = ILocalPro.VERSION + ILocalPro.PROS;
	static final String ID_PARAM = "/{id}/";
	static final String PROFILE = "profile";
	static final String SLASH = "/";
	static final String DETAILS = "details";

	public static final String V1_LOCALPRO_PROFILE = V1_PROFILE + ID_PARAM + PROFILE;
	public static final String V1_LOCALPRO_DETAILS = V1_LOCALPRO_PROFILE + SLASH + DETAILS;

	@GET
	@Path(V1_LOCALPRO_PROFILE)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId);

	@PUT
	@Path(V1_LOCALPRO_PROFILE)
	@Consumes(MediaType.APPLICATION_JSON)
	Response addProfile(
		@PathParam(value = "id") @Size(min = 20, max = 25) String localProId,
		@NotNull @Valid CreateProfileRequestDTO profile);

	@PUT
	@Path(V1_LOCALPRO_DETAILS)
	@Consumes(MediaType.APPLICATION_JSON)
	Response addProfileDetail(
			@PathParam(value = "id") @Size(min = 20, max = 25) String localProId,
			@NotNull @Valid CreateDetailRequestDTO detail);
}