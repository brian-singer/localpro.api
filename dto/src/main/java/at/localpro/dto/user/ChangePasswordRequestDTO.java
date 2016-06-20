package at.localpro.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class ChangePasswordRequestDTO {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
