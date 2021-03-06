package at.localpro.dto.event;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import at.localpro.dto.common.BaseDTO;

/**
 * LocalPro Event. All rights reserved.
 */
public class EventDTO extends BaseDTO {

	@Size(min = 20, max = 25)
	private String localProId;

	@NotNull
	private String eventType;

	@NotNull
	private LocationDTO location;

	@NotNull
	private DateTime eventStart;

	@NotNull
	private DateTime eventEnd;

	private String details;

	private Set<String> users;

	public String getLocalProId() {
		return localProId;
	}

	public void setLocalProId(String localProId) {
		this.localProId = localProId;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public DateTime getEventStart() {
		return eventStart;
	}

	public void setEventStart(DateTime eventStart) {
		this.eventStart = eventStart;
	}

	public DateTime getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(DateTime eventEnd) {
		this.eventEnd = eventEnd;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}
}
