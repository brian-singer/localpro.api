package at.localpro.dto.event;

public class LocationDTO {

	private String longitude;
	private String latitude;

	public LocationDTO() {
	}

	public LocationDTO(String longitude, String latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
