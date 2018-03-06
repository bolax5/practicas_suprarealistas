package es.urjc.app.responses;

public class LoginResponse {
	private long userId;
	private String rol;
public LoginResponse() {
	
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getRol() {
	return rol;
}
public void setRol(String rol) {
	this.rol = rol;
}

}
