package at.localpro.dto.profile;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CreateDetailRequestDTO {

	@NotNull
	@ApiModelProperty(required = true)
	private String sport;

	@ApiModelProperty(required = true)
	private String experience;

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
