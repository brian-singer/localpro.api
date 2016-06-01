package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.localpro.IProfile;
import at.localpro.dto.profile.DetailRequestDTO;
import at.localpro.dto.profile.ProfileRequestDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;
import at.localpro.rest.util.RestUtil;

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
	public Response addProfile(String localProId, ProfileRequestDTO profile) {
		client.put(Request.PROFILE.getUri(), profile, localProId);
		return RestUtil.createResourceCreatedResponse("/v1/localpros/" + localProId + "/" + "profile");
	}

	@Override
	public Response addProfileDetail(String localProId, DetailRequestDTO detail) {
		client.put(Request.PROFILE_DETAIL.getUri(), detail, localProId);
		return RestUtil.createResourceCreatedResponse("/v1/localpros/" + localProId + "/" + "profile");
	}

}
