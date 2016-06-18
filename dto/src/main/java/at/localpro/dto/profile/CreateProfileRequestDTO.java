package at.localpro.dto.profile;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CreateProfileRequestDTO {

	@NotBlank
	@Size(min = 2, max = 120)

	
	private String city;

	@Valid
	private List<CreateDetailRequestDTO> sportDetails;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<CreateDetailRequestDTO> getSportDetails() {
		return sportDetails;
	}

	public void setSportDetails(List<CreateDetailRequestDTO> sportDetails) {
		this.sportDetails = sportDetails;
	}

}
