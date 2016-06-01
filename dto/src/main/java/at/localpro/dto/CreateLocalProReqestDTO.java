package at.localpro.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiParam;

import at.localpro.dto.profile.ProfileDTO;
import at.localpro.dto.user.CreateUserRequestDTO;

public class CreateLocalProReqestDTO {

	@NotNull
	@Valid
	@ApiParam(required = true)
	private CreateUserRequestDTO user;

	@Valid
	private ProfileDTO profile;

	public CreateUserRequestDTO getUser() {
		return user;
	}

	public void setUser(CreateUserRequestDTO userDTO) {
		this.user = userDTO;
	}

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

}
