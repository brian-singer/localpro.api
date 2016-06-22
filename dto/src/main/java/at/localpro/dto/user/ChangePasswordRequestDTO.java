package at.localpro.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordRequestDTO {

	@NotEmpty
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
