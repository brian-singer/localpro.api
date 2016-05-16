package at.localpro.dto.user;

import at.localpro.domain.user.LoginSystem;
import at.localpro.dto.common.BaseDTO;

public class UserDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private String email;
	private LoginSystem loginType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginSystem getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginSystem loginType) {
		this.loginType = loginType;
	}

}
