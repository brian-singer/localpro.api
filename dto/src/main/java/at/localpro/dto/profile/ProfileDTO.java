package at.localpro.dto.profile;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import at.localpro.dto.common.BaseAuditDTO;

public class ProfileDTO extends BaseAuditDTO {

	@NotBlank
	@Size(min = 2, max = 120)
	private String city;

	@Valid
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
