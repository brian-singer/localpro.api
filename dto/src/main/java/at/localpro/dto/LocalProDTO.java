package at.localpro.dto;

import at.localpro.dto.common.BaseAuditDTO;
import at.localpro.dto.profile.ProfileDTO;
import at.localpro.dto.user.UserDTO;

/**
 * LocalPro. All rights reserved.
 */
public class LocalProDTO extends BaseAuditDTO {

	private UserDTO user;

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
