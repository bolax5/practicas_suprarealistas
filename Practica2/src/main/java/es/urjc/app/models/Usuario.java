package es.urjc.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    
    
   @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
   private Set<Partida> gameplays = new HashSet<>();
   
   @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
   private Set<IntentoConexion> connections = new HashSet<>();
    
    
	private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private String country;
    private String city;
    private int isAdmin;
    private int numAttempts;
    private int blocked;
    
    
    public Usuario()  {
    	
    }

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Set<Partida> getGameplays() {
		return gameplays;
	}
	public void setGameplays(Set<Partida> gameplays) {
		this.gameplays = gameplays;
	}
	public int getNumAttempts() {
		return numAttempts;
	}
	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	public Set<IntentoConexion> getConnections() {
		return connections;
	}

	public void setConnections(Set<IntentoConexion> connections) {
		this.connections = connections;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
    
}
