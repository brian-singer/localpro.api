package at.localpro.dto.event;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterRequestDTO {

	@NotBlank
	private String userId;

	public RegisterRequestDTO() {
	}

	public RegisterRequestDTO(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
