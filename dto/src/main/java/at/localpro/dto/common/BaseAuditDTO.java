package at.localpro.dto.common;

import org.joda.time.DateTime;

public class BaseAuditDTO extends BaseDTO {

	private DateTime createdDate;
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
