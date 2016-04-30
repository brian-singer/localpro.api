package at.localpro.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiParam;

import at.localpro.dto.common.BaseAuditDTO;
import at.localpro.dto.profile.ProfileDTO;
import at.localpro.dto.user.UserDTO;

/**
 * LocalPro. All rights reserved.
 */
public class LocalProDTO extends BaseAuditDTO {

	@NotNull
	@Valid
	@ApiParam(required = true)
	private UserDTO user;

	@Valid
	private ProfileDTO profile;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

}
