package at.localpro.dto.error;

public class Error {

	private Integer code;
	private String detail;

	public Error() {
	}

	public Error(Integer code, String detail) {
		this.code = code;
		this.detail = detail;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
