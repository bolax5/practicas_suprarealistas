package es.urjc.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.app.models.*;
import es.urjc.app.repositories.*;
import es.urjc.app.responses.*;

@RestController
@RequestMapping("/")
public class RestControllers {
	
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private IntentoRepository iRepository;
	@Autowired
	private GameRepository gRepository;
	private int attempts = 0;
    
	
    
    @PostConstruct
    public void init() {
    	Usuario u = new Usuario();
    	Usuario u1 = new Usuario();
    	Juego j1 = new Juego();
    	Juego j2 = new Juego();
    	
    	j1.setName("Fifa 18");
    	j1.setMinAge(3);
    	j1.setDemo("http://www.yotube.com");
    	j1.setDescription("El mejor juego de futbol");
    	j1.setNationality("Canadian");
    	j1.setVersion("3.2");
    	j1.setStudio("EA");
    	j1.setYear(2017);
    	
    	j2.setName("GTA V");
    	j2.setMinAge(18);
    	j2.setDemo("http://youtube.com");
    	j2.setDescription("Vuelve la mejor acción");
    	j2.setNationality("Canadian");
    	j2.setStudio("Rockstar North");
    	j2.setYear(2015);
    	j2.setVersion("1.42");
    	
    	u.setUsername("Admin");
    	u.setPassword("admin");
    	u.setIsAdmin(1);
    	u1.setUsername("Paco-Gamer");
    	u1.setPassword("1234");
    	u1.setIsAdmin(0);

    	
    	this.uRepository.save(u);
    	this.uRepository.save(u1);
    	this.gRepository.save(j1);
    	this.gRepository.save(j2);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(Usuario user ,HttpServletRequest request){
    	IntentoConexion ic = new IntentoConexion();
    	Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd" );
    	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    	ic.setUsername(user.getUsername());
    	ic.setDate(dateFormat.format(date));
    	ic.setTime(timeFormat.format(date));
    	ic.setIP(request.getRemoteAddr());
    	
        Usuario u = this.uRepository.findByUsername(user.getUsername());
        
         if (u == null) {
        	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }else {
        	 ic.setUser(u);
        	 
        	 if (u.getPassword().equals(user.getPassword()) && u.getBlocked()!=1) {
        		 ic.setResult(true);
        		 iRepository.save(ic);
        		 LoginResponse res = new LoginResponse();
        		 res.setUserId(u.getIdUser());
        		 String rol = u.getIsAdmin() == 1 ? "admin" : "gamer";
        		 res.setRol(rol);
        		 return new ResponseEntity<>(res,HttpStatus.OK);
        	 }else {
        		 ic.setResult(false);
    			 iRepository.save(ic);
        		 attempts++;
        		 if(attempts > 3) {
        			 u.setBlocked(1);
        			 uRepository.save(u);
        			 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        		 }
        		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        	 }
         }	
    }
    
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Juego>> getGames(@RequestParam(value="filter",required = false)String filter){
    	Iterable<Juego> it =  this.gRepository.findAll();
    	if (filter == null) {
    		return new ResponseEntity<>(it,HttpStatus.OK);
    	}
    	List<Juego> filtered = new ArrayList<>();
    	filter = filter.toLowerCase();
    	for (Juego j: it) {
    		if (j.getName().toLowerCase().contains(filter)) {
    			filtered.add(j);
    		}
    	}
    	return new ResponseEntity<>(filtered,HttpStatus.OK);
    	
    }
    @RequestMapping(value = "/game/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Juego> getGame(@PathVariable("id") Long id){
    	Juego j = this.gRepository.findByIdGame(id);
    	return new ResponseEntity<>(j,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ResponseEntity<Juego> newGame(@RequestParam(value="name")String name, Integer minAge, Integer year, String studio,String version, String nationality,String description,String demo){
    	Juego j = new Juego();
    	j.setName(name);
    	j.setMinAge(minAge);
    	j.setYear(year);
    	j.setStudio(studio);
    	j.setVersion(version);
    	j.setNationality(nationality);
    	j.setDescription(description);
    	j.setDemo(demo);
    	this.gRepository.save(j);
    	return new ResponseEntity<>(j,HttpStatus.CREATED);
    	
    }
    
    @RequestMapping(value = "/game/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Juego> deleteGame(@PathVariable(value="name")String name) {
    	Juego j = this.gRepository.findByName(name);
    	if (j == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND );    	
    	}
    	this.gRepository.delete(j);
    	return new ResponseEntity<>(j,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/game/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Juego> updateGame(@PathVariable Long id, String name, Integer year,Integer minAge,String studio,String version, String nationality,String description,String demo) {
    	Juego j = this.gRepository.findByIdGame(id);
    	if (j == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND );    	
    	}
    	if(name != null)
    		j.setName(name);
    	if(year != null)
    		j.setYear(year);
    	if(minAge != null)
    		j.setMinAge(minAge);
    	if(studio != null)
    		j.setStudio(studio);
    	if(version != null)
    		j.setVersion(version);
    	if(nationality != null)
    		j.setNationality(nationality);
    	if(description != null)
    		j.setDescription(description);
    	if(demo != null)
    		j.setDemo(demo);
    	
    	gRepository.save(j);
    	return new ResponseEntity<>(j,HttpStatus.OK);
    }
}
