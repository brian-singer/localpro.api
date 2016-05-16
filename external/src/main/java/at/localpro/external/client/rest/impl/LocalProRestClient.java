package at.localpro.external.client.rest.impl;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.localpro.ILocalPro;
import at.localpro.dto.CreateLocalProReqestDTO;
import at.localpro.external.client.rest.Request;
import at.localpro.external.client.rest.RestClient;

@WebService
@Service
public class LocalProRestClient implements ILocalPro {

	@Autowired
	private RestClient client;

	@Override
	public Object get(String localProId) {
		return client.getByUri(Request.GET_LOCAL_PRO.getUri(), localProId);
	}

	@Override
	public Object add(CreateLocalProReqestDTO localPro) {
		// @formatter:off
		return Response.status(Status.CREATED).location(
				client.post(Request.LOCAL_PROS.getUri(), localPro)).build();
		// @formatter:on
	}

	@Override
	public Object getByEmail(String email) {
		return client.queryUnique(Request.LOCAL_PROS.getUri(), new DefaultMapEntry<String, String>("email", email));
	}

	@Override
	public Object getAllPros() {
		// Do not expose
		return null;
	}

}
