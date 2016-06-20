package at.localpro.external.client.rest;

import at.localpro.IEvent;
import at.localpro.ILocalPro;
import at.localpro.IProfile;
import at.localpro.IUser;

public enum Request {

	GET_LOCALPRO(Request.API + ILocalPro.ID),
	GET_LOCALPRO_SPORTS(Request.API + ILocalPro.SPORTS),
	GET_USER(Request.API + IUser.ID),
	GET_ALL_USERS(Request.API + IUser.V1_SEARCH),
	GET_EVENT(Request.API + IEvent.ID),
	GET_LOCALPRO_EVENTS(Request.API + IEvent.V1_LOCAL_PRO_EVENTS),
	GET_LOCALPRO_ID(Request.API + ILocalPro.V1_GET_ID),
	LOCALPROS(Request.API + ILocalPro.V1_LOCALPROS),
	USERS(Request.API + IUser.V1_USERS),
	CHANGE_PASSWORD(Request.API + IUser.V1_CHANGE_PASSWORD),
	DELETE_USER(Request.API + IUser.V1_DELETE),
	LOGIN(Request.API + IUser.V1_LOGIN),
	EVENTS(Request.API + IEvent.V1_EVENTS),
	EVENT_REGISTER(Request.API + IEvent.REGISTER),
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
