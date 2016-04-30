package at.localpro.dto.common;

import org.joda.time.DateTime;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BaseAuditDTO extends BaseDTO {

	@ApiModelProperty(value = "The date of resource created")
	private DateTime createdDate;

	@ApiModelProperty(value = "The last modification")
	private DateTime lastModified;

	public DateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(DateTime lastModified) {
		this.lastModified = lastModified;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
}
