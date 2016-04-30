package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.localpro.IProfile;
import at.localpro.dto.profile.DetailRequestDTO;
import at.localpro.dto.profile.ProfileRequestDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;

@WebService
@Service
public class ProfileRestClient implements IProfile {

	@Autowired
	private RestClient client;

	@Override
	public Object get(String localProId) {
		return client.getByUri(Request.GET_LOCAL_PRO_EVENTS.getUri(), localProId);
	}

	@Override
	public Object addProfile(String localProId, ProfileRequestDTO profile) {
		// @formatter:off
		return Response.status(Status.CREATED).location(
				client.post(Request.PROFILE.getUri(), profile, localProId)).build();
		// @formatter:on
	}

	@Override
	public Object addProfileDetail(String localProId, DetailRequestDTO detail) {
		// @formatter:off
		return Response.status(Status.CREATED).location(
				client.post(Request.PROFILE_DETAIL.getUri(), detail, localProId)).build();
		// @formatter:on
	}

}
