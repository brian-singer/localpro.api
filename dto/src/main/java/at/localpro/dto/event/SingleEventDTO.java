package at.localpro.dto.event;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * LocalPro Event. All rights reserved.
 */
@ApiModel
public class SingleEventDTO extends EventDTO {

	@NotNull
	@Size(min = 20, max = 25)
	private String localProId;

	public String getLocalProId() {
		return localProId;
	}

	public void setLocalProId(String localProId) {
		this.localProId = localProId;
	}

}
