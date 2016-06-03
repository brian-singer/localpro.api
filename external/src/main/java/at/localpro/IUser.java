package at.localpro;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import at.localpro.dto.user.ChangePasswordRequestDTO;
import at.localpro.dto.user.CreateUserRequestDTO;
import at.localpro.dto.user.UserLoginRequestDTO;

public interface IUser {

	public static final String V1_USERS = IUser.VERSION + IUser.USERS;

	static final String VERSION = "/v1/";

	static final String USERS = "users";
	static final String V1_SEARCH = IUser.VERSION + IUser.USERS + "/search";
	static final String ID = V1_USERS + "/{id}";
	public static final String V1_LOGIN = ID + "/login";
	public static final String V1_CHANGE_PASSWORD = ID + "/changepassword";
	public static final String V1_DELETE = ID + "/delete";

	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String userId);

	@GET
	@Path(V1_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	Object getAllUsers();

	@GET
	@Path(V1_USERS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByEmail(
			@QueryParam(value = "email") @Email String email);

	@POST
	@Path(V1_USERS)
	@Consumes(MediaType.APPLICATION_JSON)
	Response add(@NotNull @Valid CreateUserRequestDTO user);

	@PUT
	@Path(V1_LOGIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response login(
		@PathParam(value = "id") @Size(min = 20, max = 25) String userId,
		@NotNull @Valid UserLoginRequestDTO loginRequest);

	@PUT
	@Path(V1_CHANGE_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON)
	Response changePassword(
		@PathParam(value = "id") @Size(min = 20, max = 25) String userId,
		@NotNull @Valid ChangePasswordRequestDTO changePasswordRequest);

	@DELETE
	@Path(V1_DELETE)
	@Consumes(MediaType.APPLICATION_JSON)
	Response delete(
		@PathParam(value = "id") @Size(min = 20, max = 25) String userId);

}
