package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import at.localpro.ILocalPro;
import at.localpro.dto.CreateLocalProReqestDTO;
import at.localpro.dto.LocalProDTO;
import at.localpro.dto.LocalProIdResponse;
import at.localpro.dto.SportsDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;
import at.localpro.rest.util.WebServiceResponseBuilder;

@WebService
@Service
public class LocalProRestClient implements ILocalPro {

	@Autowired
	private RestClient client;

	@Override
	public Object get(String localProId) {
		return client.getByUri(Request.GET_LOCALPRO.getUri(), new ParameterizedTypeReference<LocalProDTO>() {
		}, localProId);
	}

	@Override
	public Response add(CreateLocalProReqestDTO localPro) {
		// TODO handle respones somewhere :)
		client.post(Request.LOCALPROS.getUri(), localPro);
		return WebServiceResponseBuilder.ok().build();
	}

	@Override
	public Object get(String email, String userId) {
		if (StringUtils.isNotBlank(email)) {
			return client.queryUnique(Request.LOCALPROS.getUri(), new DefaultMapEntry<String, String>("email", email),
					new ParameterizedTypeReference<LocalProDTO>() {
					});
		}
		if (StringUtils.isBlank(userId)) {
			return WebServiceResponseBuilder.badRequest().build();
		}
		return client.queryUnique(Request.LOCALPROS.getUri(), new DefaultMapEntry<String, String>("userid", userId),
				new ParameterizedTypeReference<LocalProDTO>() {
				});
	}

	@Override
	public Object getAllPros() {
		// Do not expose
		return null;
	}

	@Override
	public Object getId(String userId) {
		return client.queryUnique(Request.GET_LOCALPRO_ID.getUri(),
				new DefaultMapEntry<String, String>("userid", userId),
				new ParameterizedTypeReference<LocalProIdResponse>() {
				});
	}

	@Override
	public Object getSports(String localProId) {
		return client.getByUri(Request.GET_LOCALPRO_SPORTS.getUri(), new ParameterizedTypeReference<SportsDTO>() {
		}, localProId);
	}

}
