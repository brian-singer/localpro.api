package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.localpro.IUser;
import at.localpro.dto.user.CreateUserRequestDTO;
import at.localpro.dto.user.LoginRequestDTO;
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
		return client.queryUnique(Request.USERS.getUri(), new DefaultMapEntry<String, String>("email", email));
	}

	@Override
	public Object add(CreateUserRequestDTO user) {
		return Response.status(Status.CREATED).location(
				client.post(Request.USERS.getUri(), user)).build();
	}

	@Override
	public Object login(String userId, LoginRequestDTO loginRequest) {
		client.put(Request.GET_USER.getUri(), loginRequest, userId);
		return client.getByUri(Request.GET_USER.getUri(), userId);
	}

}
