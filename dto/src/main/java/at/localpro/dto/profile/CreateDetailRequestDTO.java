package at.localpro.dto.profile;

import javax.validation.constraints.NotNull;

public class CreateDetailRequestDTO {

	@NotNull
	private String sport;

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
