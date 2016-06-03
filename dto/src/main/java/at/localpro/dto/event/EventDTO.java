package at.localpro.dto.event;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import at.localpro.dto.Sport;
import at.localpro.dto.common.BaseDTO;

/**
 * LocalPro Event. All rights reserved.
 */
public class EventDTO extends BaseDTO {

	@Size(min = 20, max = 25)
	private String localProId;

	@NotNull
	private Sport eventType;

	@NotNull
	private Location location;

	@NotNull
	private DateTime eventStart;

	@NotNull
	private DateTime eventEnd;

	public String getLocalProId() {
		return localProId;
	}

	public void setLocalProId(String localProId) {
		this.localProId = localProId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Sport getEventType() {
		return eventType;
	}

	public void setEventType(Sport eventType) {
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
}
