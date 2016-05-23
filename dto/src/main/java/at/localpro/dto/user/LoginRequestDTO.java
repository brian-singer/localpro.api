package at.localpro.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequestDTO {

	@NotEmpty
	private String password;
	private Boolean rememberMe;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
