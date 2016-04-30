package at.localpro.dto.profile;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class ProfileRequestDTO {

	@NotBlank
	@Size(min = 2, max = 120)
	private String city;

	@Valid
	private List<DetailDTO> sportDetails;

	@ApiModelProperty(value = "The version of the existing LocalPro for consistency checks")
	private DateTime version;

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

	public DateTime getVersion() {
		return version;
	}

	public void setVersion(DateTime version) {
		this.version = version;
	}
}
