package at.localpro.dto.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class CreateUserRequestDTO {

	@NotBlank
	@Size(min = 1, max = 64)
	@ApiModelProperty(required = true)
	private String firstName;
	@NotBlank
	@Size(min = 1, max = 64)
	@ApiModelProperty(required = true)
	private String lastName;
	@Email
	@ApiModelProperty(required = true)
	private String email;
	@NotBlank
	@Size(min = 6, max = 20)
	@ApiModelProperty(required = true)
	private String password;

	private Boolean newsletter;
	private Boolean administrator;

	@NotNull
	@ApiModelProperty(required = true)
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
