package at.localpro.dto.location;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class GeoLocationDTO {

	@NotNull
	private BigDecimal latitude;

	@NotNull
	private BigDecimal longitude;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
}
