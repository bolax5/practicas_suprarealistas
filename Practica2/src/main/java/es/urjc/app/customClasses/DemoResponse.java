package es.urjc.app.customClasses;

public class DemoResponse {
	private boolean playability;
	private Long iniTime;
	
	public DemoResponse() {
		
	}

	public boolean isPlayability() {
		return playability;
	}

	public void setPlayability(boolean playability) {
		this.playability = playability;
	}

	public Long getIniTime() {
		return iniTime;
	}

	public void setIniTime(Long iniTime) {
		this.iniTime = iniTime;
	}
	
}
