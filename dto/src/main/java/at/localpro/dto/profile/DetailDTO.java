package at.localpro.dto.profile;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModelProperty;

import at.localpro.domain.Sport;

public class DetailDTO {

	@NotNull
	@ApiModelProperty(required = true, dataType = "string")
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
