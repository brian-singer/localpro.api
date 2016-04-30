package at.localpro.dto.event;

import java.util.List;

public class EventListingDTO {

	private List<EventDTO> events;

	public EventListingDTO() {
	}

	public EventListingDTO(List<EventDTO> events) {
		this.events = events;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}
}
