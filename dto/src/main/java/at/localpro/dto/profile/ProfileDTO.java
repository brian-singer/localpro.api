package at.localpro.dto.profile;

import java.util.List;

import at.localpro.dto.common.BaseDTO;

public class ProfileDTO extends BaseDTO {

	private String city;

	private List<DetailDTO> sportDetails;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<DetailDTO> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<DetailDTO> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
