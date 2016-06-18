package at.localpro.dto;

public class LocalProIdResponse {

	public LocalProIdResponse() { }

	public LocalProIdResponse(String localProId) {
		this.localProId = localProId;
	}

	private String localProId;

	public String getLocalProId() {
		return localProId;
	}

	public void setLocalProId(String localProId) {
		this.localProId = localProId;
	}
}
