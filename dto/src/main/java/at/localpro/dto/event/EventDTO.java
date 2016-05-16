package at.localpro.dto.event;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.wordnik.swagger.annotations.ApiModelProperty;

import at.localpro.domain.Sport;
import at.localpro.domain.event.Location;
import at.localpro.dto.common.BaseDTO;

public class EventDTO extends BaseDTO {

	@ApiModelProperty(hidden = true)
	private String localProId;

	@NotNull
	@ApiModelProperty(required = true, dataType = "string")
	private Sport eventType;

	@NotNull
	@ApiModelProperty(required = true)
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
