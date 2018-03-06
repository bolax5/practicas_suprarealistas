package es.urjc.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class IntentoConexion {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTryConection;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Usuario user;
    
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	private String date;
	private String time;
	private String IP;
	private String username;
	private boolean result;
	public Long getIdTryConection() {
		return idTryConection;
	}
	public void setIdTryConection(Long idTryConection) {
		this.idTryConection = idTryConection;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
