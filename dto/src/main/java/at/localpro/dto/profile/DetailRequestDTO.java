package at.localpro.dto.profile;

import org.joda.time.DateTime;

public class DetailRequestDTO extends DetailDTO {

	private DateTime version;

	public DateTime getVersion() {
		return version;
	}

	public void setVersion(DateTime version) {
		this.version = version;
	}
}
