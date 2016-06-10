package at.localpro.dto.profile;

import java.math.BigDecimal;

import at.localpro.dto.common.BaseDTO;

public class DetailDTO extends BaseDTO {

	private String sport;
	private String experience;

	private BigDecimal experienceRating;

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

	public BigDecimal getExperienceRating() {
		return experienceRating;
	}

	public void setExperienceRating(BigDecimal experienceRating) {
		this.experienceRating = experienceRating;
	}
}
