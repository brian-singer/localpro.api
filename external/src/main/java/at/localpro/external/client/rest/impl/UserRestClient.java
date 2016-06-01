package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import at.localpro.IUser;
import at.localpro.dto.user.ChangePasswordRequestDTO;
import at.localpro.dto.user.CreateUserRequestDTO;
import at.localpro.dto.user.UserLoginRequestDTO;
import at.localpro.dto.user.UserDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;

@WebService
@Service
public class UserRestClient implements IUser {

	@Autowired
	private RestClient client;

	@Override
	public Object get(String userId) {
		return client.getByUri(Request.GET_USER.getUri(), userId);
	}

	@Override
	public Object getAllUsers() {
		return client.getByUri(Request.GET_ALL_USERS.getUri());
	}

	@Override
	public Object getByEmail(String email) {
		return client.queryUnique(Request.USERS.getUri(), new DefaultMapEntry<String, String>("email", email),
				new ParameterizedTypeReference<UserDTO>() {
				});
	}

	@Override
	public Object add(CreateUserRequestDTO user) {
		return Response.status(Status.CREATED).location(client.post(Request.USERS.getUri(), user)).build();
	}

	@Override
	public Object login(String userId, UserLoginRequestDTO loginRequest) {
		client.put(Request.LOGIN.getUri(), loginRequest, userId);
		return client.getByUri(Request.GET_USER.getUri(), userId);
	}

	@Override
	public Response changePassword(String userId, ChangePasswordRequestDTO changePasswordRequest) {
		client.put(Request.CHANGE_PASSWORD.getUri(), changePasswordRequest, userId);
		return Response.ok().build();
	}

	@Override
	public Response delete(String userId) {
		client.delete(Request.DELETE_USER.getUri(), userId);
		return Response.ok().build();
	}

}
