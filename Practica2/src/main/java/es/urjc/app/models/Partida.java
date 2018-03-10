package es.urjc.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGameplay;
    
    private String date;
    private String time;
    private Long duration;
    
    
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Juego game;
    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;
    
    
    public Partida () {
    	
    }
	public Long getIdGameplay() {
		return idGameplay;
	}
	public void setIdGameplay(Long idGameplay) {
		this.idGameplay = idGameplay;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimee() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Juego getGame() {
		return game;
	}
	public void setGame(Juego game) {
		this.game = game;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
    
    
    
    
    
}
