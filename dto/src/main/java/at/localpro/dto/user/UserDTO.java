package at.localpro.dto.user;

import at.localpro.dto.common.BaseDTO;

public class UserDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String loginType;
	private Boolean newsletter;
	private Boolean administrator;
	private Boolean rememberMe;
	private Boolean localPro;
	private String lastLogin;

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

	public Boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}

	public Boolean getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public Boolean getLocalPro() {
		return localPro;
	}

	public void setLocalPro(Boolean localPro) {
		this.localPro = localPro;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

}
