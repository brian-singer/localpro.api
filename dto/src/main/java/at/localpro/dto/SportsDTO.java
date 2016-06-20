package at.localpro.dto;

public class SportsDTO {

	String[] sports;

	public SportsDTO() {
	}

	public SportsDTO(String[] sports) {
		this.sports = sports;
	}

	public String[] getSports() {
		return sports;
	}

	public void setSports(String[] sports) {
		this.sports = sports;
	}
}
