package at.localpro.dto;

import at.localpro.dto.profile.CreateProfileRequestDTO;

public class CreateLocalProProfileRequestDTO extends CreateProfileRequestDTO {

	private String localProId;

	public String getLocalProId() {
		return localProId;
	}

	public void setLocalProId(String localProId) {
		this.localProId = localProId;
	}

}
