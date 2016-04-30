package at.localpro.dto.error;

public enum Code {

	INVALID_REQUEST(400);

	private Integer code;

	private Code(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
