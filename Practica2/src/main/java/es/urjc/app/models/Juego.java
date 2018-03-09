package es.urjc.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGame;
    
    @OneToMany(mappedBy="game", cascade = CascadeType.ALL)
    private Set<Partida> gameplays = new HashSet<>();
    
    private String name;
    private String version;
    private int year;
    private String studio;
    private String nationality;
    private int minAge;
    @Column(length=700)
    private String description;
    private String demo;
    private String imgSource;
    private boolean playabality;
    private int playTime;
    
    public Juego () {
    	
    }
    
	public Juego( String name, String version, int year, String studio, String nationality,
			int minAge, String description, String demo) {
		this.name = name;
		this.version = version;
		this.year = year;
		this.studio = studio;
		this.nationality = nationality;
		this.minAge = minAge;
		this.description = description;
		this.demo = demo;
	}

	public Long getIdGame() {
		return idGame;
	}
	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDemo() {
		return demo;
	}
	public void setDemo(String demo) {
		this.demo = demo;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}

	public boolean isPlayabality() {
		return playabality;
	}

	public void setPlayabality(boolean playabality) {
		this.playabality = playabality;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	
}
