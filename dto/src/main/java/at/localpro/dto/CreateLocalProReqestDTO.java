package at.localpro.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import at.localpro.dto.profile.CreateProfileRequestDTO;
import at.localpro.dto.user.CreateUserRequestDTO;

public class CreateLocalProReqestDTO {

	@NotNull
	@Valid
	private CreateUserRequestDTO user;

	@NotNull
	@Valid
	private CreateProfileRequestDTO profile;

	public CreateUserRequestDTO getUser() {
		return user;
	}

	public void setUser(CreateUserRequestDTO userDTO) {
		this.user = userDTO;
	}

	public CreateProfileRequestDTO getProfile() {
		return profile;
	}

	public void setProfile(CreateProfileRequestDTO profile) {
		this.profile = profile;
	}

}
