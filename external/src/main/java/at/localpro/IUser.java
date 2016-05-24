package at.localpro;

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
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import at.localpro.dto.user.ChangePasswordRequestDTO;
import at.localpro.dto.user.CreateUserRequestDTO;
import at.localpro.dto.user.UserLoginRequestDTO;
import at.localpro.dto.user.UserDTO;

@Api(value = IUser.V1_USERS)
public interface IUser {

	public static final String V1_USERS = IUser.VERSION + IUser.USERS;

	static final String VERSION = "/v1/";

	static final String USERS = "users";
	static final String V1_SEARCH = IUser.VERSION + IUser.USERS + "/search";
	static final String ID = V1_USERS + "/{id}";
	public static final String V1_LOGIN = ID + "/login";
	public static final String V1_CHANGE_PASSWORD = ID + "/changepassword";

	// @formatter:off
	@ApiOperation(value = "Get the user by id", response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:User not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(ID)
	@Produces(MediaType.APPLICATION_JSON)
	Object get(
			@PathParam(value = "id") @Size(min = 20, max = 25) String userId);

	@ApiOperation(value = "Search users", response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:None found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	Object getAllUsers();

	@ApiOperation(value = "Get the user by email", response = UserDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Event not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@GET
	@Path(V1_USERS)
	@Produces(MediaType.APPLICATION_JSON)
	Object getByEmail(
			@QueryParam(value = "email") @Email String email);

	@ApiOperation(value = "Post a user to the Community!")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Resource created"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@POST
	@Path(V1_USERS)
	@Consumes(MediaType.APPLICATION_JSON)
	Object add(@NotNull @Valid CreateUserRequestDTO user);

	@ApiOperation(value = "User login")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Existing localpro not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@PUT
	@Path(V1_LOGIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Object login(
		@PathParam(value = "id") @Size(min = 20, max = 25) String userId,
		@NotNull @Valid UserLoginRequestDTO loginRequest);

	@ApiOperation(value = "User change password")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "error:400, cause:Validation Error", response = Error.class),
		@ApiResponse(code = 404, message = "error:404, cause:Existing localpro not found", response = Error.class),
		@ApiResponse(code = 500, message = "error:500, cause:Unknown error occured", response = Error.class) })
	@PUT
	@Path(V1_CHANGE_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON)
	Response changePassword(
		@PathParam(value = "id") @Size(min = 20, max = 25) String userId,
		@NotNull @Valid ChangePasswordRequestDTO changePasswordRequest);

}
