package at.localpro.dto.common;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BaseDTO {

	@ApiModelProperty(hidden = true)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
