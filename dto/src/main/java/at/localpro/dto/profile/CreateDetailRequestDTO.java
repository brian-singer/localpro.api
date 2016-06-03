package at.localpro.dto.profile;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import at.localpro.dto.Sport;

public class CreateDetailRequestDTO {

	@NotNull
	private Sport sport;

	private String experience;

	@DecimalMin(value = "0")
	@DecimalMax(value = "10")
	private BigDecimal experienceRating;

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
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
