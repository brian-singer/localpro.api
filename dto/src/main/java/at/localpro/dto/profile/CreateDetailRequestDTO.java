package at.localpro.dto.profile;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CreateDetailRequestDTO {

	@NotNull
	@ApiModelProperty(required = true)
	private String sport;

	@ApiModelProperty(required = true)
	private String experience;

	@ApiModelProperty(required = true)
	@DecimalMin(value = "0")
	@DecimalMax(value = "10")
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
