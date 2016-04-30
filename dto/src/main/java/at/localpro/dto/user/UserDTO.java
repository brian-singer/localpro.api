package at.localpro.dto.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

import at.localpro.dto.common.BaseDTO;

public class UserDTO extends BaseDTO {

	@NotBlank
	@Size(min = 1, max = 64)
	private String firstName;
	@NotBlank
	@Size(min = 1, max = 64)
	private String lastName;
	@Email
	private String email;

	@ApiModelProperty(dataType = "string")
	@NotNull
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
