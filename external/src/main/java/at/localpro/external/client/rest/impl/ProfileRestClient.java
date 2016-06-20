package at.localpro.external.client.rest.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import at.localpro.ILocalPro;
import at.localpro.IProfile;
import at.localpro.dto.event.EventDTO;
import at.localpro.dto.profile.CreateDetailRequestDTO;
import at.localpro.dto.profile.CreateProfileRequestDTO;
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
		return client.getByUri(Request.GET_LOCALPRO_EVENTS.getUri(), new ParameterizedTypeReference<List<EventDTO>>() {
		}, localProId);
	}

	@Override
	public Response addProfile(String localProId, CreateProfileRequestDTO profile) {
		client.put(Request.PROFILE.getUri(), profile, localProId);
		return RestUtil.createResourceCreatedResponse(ILocalPro.V1_GET_ID, localProId);
	}

	@Override
	public Response addProfileDetail(String localProId, CreateDetailRequestDTO detail) {
		client.put(Request.PROFILE_DETAIL.getUri(), detail, localProId);
		return RestUtil.createResourceCreatedResponse(IProfile.V1_LOCALPRO_PROFILE, localProId);
	}

}
