package at.localpro.external.client.rest;

import at.localpro.IEvent;
import at.localpro.ILocalPro;
import at.localpro.IProfile;
import at.localpro.IUser;

public enum Request {

	GET_LOCAL_PRO(Request.API + ILocalPro.ID),
	GET_USER(Request.API + IUser.ID),
	GET_ALL_USERS(Request.API + IUser.V1_SEARCH),
	GET_EVENT(Request.API + IEvent.ID),
	GET_LOCAL_PRO_EVENTS(Request.API + IEvent.V1_LOCAL_PRO_EVENTS),
	LOCAL_PROS(Request.API + ILocalPro.V1_LOCALPROS),
	USERS(Request.API + IUser.V1_USERS),
	EVENTS(Request.API + IEvent.V1_EVENTS),
	PROFILE(Request.API + IProfile.V1_LOCALPRO_PROFILE),
	PROFILE_DETAIL(Request.API + IProfile.V1_LOCALPRO_DETAILS);

	private String uri;
	static final String API = "/api";

	private Request(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}
}
