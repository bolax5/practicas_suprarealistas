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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.app.models.*;
import es.urjc.app.repositories.*;
import es.urjc.app.responses.*;
@CrossOrigin(origins= {"http://localhost:4200","file://"},maxAge=3600)
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
    
	/*
	 * PREINICIALIZACION DE JUEGOS Y USUARIOS PARA QUE LA BASE DE DATOS NO ESTE VACIA
	 */
    
    @PostConstruct
    public void init() {
    	Usuario u = new Usuario();
    	Usuario u1 = new Usuario();
    	Juego j1 = new Juego();
    	Juego j2 = new Juego();
    	Juego j3 = new Juego();
    	Juego j4 = new Juego();
    	Juego j5 = new Juego();
    	Juego j6 = new Juego();
    	Juego j7 = new Juego();
    	Juego j8 = new Juego();
    	Juego j9 = new Juego();
    	Juego j10 = new Juego();
    	Juego j11 = new Juego();
    	Juego j12 = new Juego();
    	Juego j13 = new Juego();
    	Juego j14 = new Juego();
    	Juego j15 = new Juego();
    	Juego j16= new Juego();
    	Juego j17 = new Juego();
    	Juego j18 = new Juego();
    	Juego j19 = new Juego();
    	Juego j20 = new Juego();
    	Juego j21 = new Juego();
    	Juego j22 = new Juego();
    	Juego j23 = new Juego();
    	Juego j24 = new Juego();
    	
    	j1.setName("Fifa 18");
    	j1.setMinAge(3);
    	j1.setDemo("http://www.yotube.com");
    	j1.setDescription("Call of Duty vuelve a sus raíces con WWII, el regreso de la serie de acción en primera persona a la Segunda Guerra Mundial. Desde las frías aguas de Normandía en el día D, avanzarás por todo el frente europeo enfrentándote al eje y defendiendo la libertad en un mundo al borde de la tiranía. Vive una historia de hermandad entre soldados en la mayor campaña ambientada en la Segunda Guerra Mundial, participa en algunas de las batallas más icónicas del conflicto en el brutal y realista modo multijugador en línea o coopera ante la amenaza de muertos vivientes en la historia independiente del nuevo modo zombies.");
    	j1.setNationality("Canadian");
    	j1.setVersion("3.2");
    	j1.setStudio("EA");
    	j1.setYear(2017);
    	j1.setImgSource("./assets/img/cod.jpg");
    	j1.setPlayabality(true);
    	j1.setPlayTime(100);
    	
    	j2.setName("Call of Duty: WWII");
    	j2.setMinAge(18);
    	j2.setDemo("4h7joJnMeb4");
    	j2.setDescription("¿Estás preparado para tu temporada más importante hasta la fecha? Gracias al motor Frostbite, FIFA 18 hace que se confunda la línea que separa el mundo virtual del real, y consigue darle vida a los héroes, a los equipos y a las atmósferas que se viven en los partidos de verdad.");
    	j2.setNationality("USA");
    	j2.setStudio("Sledgehammer Games");
    	j2.setYear(2015);
    	j2.setVersion("1.42");
    	j2.setImgSource("./assets/img/fifa18.jpg");
    	j2.setPlayabality(true);
    	j2.setPlayTime(50);
    	
    	j3.setName("Fortnite");
    	j3.setMinAge(12);
    	j3.setDemo("http://youtube.com");
    	j3.setDescription("Fortnite es un juego de Epic Games que nos reta a buscar recursos en un mundo durante el día, y a sobrevivir durante la noche a los ataques de los seres fantásticos que lo pueblan y aprovechan la oscuridad para fortalecerse. El juego cuenta con elementos cooperativos, y podremos construir estructuras fortificadas, luchar contra oleadas de enemigos, y construir objetos.");
    	j3.setNationality("USA");
    	j3.setStudio("Epic Games");
    	j3.setYear(2017);
    	j3.setVersion("2.42");
    	j3.setImgSource("./assets/img/fortnite.jpg");
    	j3.setPlayabality(true);
    	j3.setPlayTime(20);
    	
    	j4.setName("Dragon Ball FighterZ");
    	j4.setMinAge(12);
    	j4.setDemo("ZGKXvvqeBuA");
    	j4.setDescription("Vuelve la acción con Dragon Ball FighterZ, el juego de lucha 2D definitivo que te convertirá en el mejor guerrero del universo. Tras el éxito de Xenoverse, llega un nuevo Dragon Ball que mejora al máximo los gráficos del anime, con una mecánica fácil de aprender pero... Difícil de dominar. Dragon Ball FighterZ viene con todo el contenido que ha hecho que las series Dragon Ball sean tan apreciadas por el público. Espectaculares enfrentamientos sin fin con luchadores extremadamente poderosos");
    	j4.setNationality("Canadian");
    	j4.setStudio("Arc System Works");
    	j4.setYear(2017);
    	j4.setImgSource("./assets/img/db.jpg");
    	j4.setPlayabality(true);
    	j4.setPlayTime(30);
    	j4.setVersion("3.12");
    	
    	j5.setName("Monster Hunter World");
    	j5.setMinAge(16);
    	j5.setDemo("oC8y2THEV7E");
    	j5.setDescription("Empuña de nuevo tu Gran Espada y adéntrate en el \"Nuevo Mundo\" para dar caza a los monstruos más feroces jamás conocidos. Tras 9 años desde su última aparición en consolas de sobremesa, la saga Monster Hunter, producida por Ryozo Tsujimoto, regresa con el título Monster Hunter World, la nueva entrega de caza lanzada de manera simultánea en todo el mundo");
    	j5.setNationality("USA");
    	j5.setStudio("Capcom");
    	j5.setYear(2018);
    	j5.setVersion("1.1");
    	j5.setImgSource("./assets/img/MonsterHunterWorld.png");
    	j5.setPlayabality(true);
    	j5.setPlayTime(10);
    
    	j6.setName("The Last Of Us");
    	j6.setMinAge(18);
    	j6.setDemo("6Mg3Y2BVR38");
    	j6.setDescription("En un mundo hostil y post-pandémico, las circunstancias desesperadas acaban uniendo a Ellie y Joel, quienes deben confiar el uno en el otro para sobrevivir en un viaje salvaje por lo que queda de Estados Unidos.");
    	j6.setNationality("USA");
    	j6.setStudio("Naughty Dog");
    	j6.setYear(2013);
    	j6.setVersion("3.42");
    	j6.setImgSource("./assets/img/Last.jpg");
    	j6.setPlayabality(true);
    	j6.setPlayTime(50);
    	
    	j7.setName("The Binding of Isaac: Afterbirth");
    	j7.setMinAge(16);
    	j7.setDemo("cvxVriP5Dvk");
    	j7.setDescription("The Binding of Isaac: Afterbirth+ es un juego de acción en vista cenital, con grandes dosis de elementos RPG y Rogue-like en el que los mundos se generan de manera aleatoria, dando lugar a probabilidades casi infinitas");
    	j7.setNationality("USA");
    	j7.setStudio("Edmund McMillen");
    	j7.setYear(2011);
    	j7.setVersion("3.42");
    	j7.setImgSource("./assets/img/Isaac.jpg");
    	j7.setPlayabality(true);
    	j7.setPlayTime(10);
    	
    	j8.setName("Los Sims 4'");
    	j8.setMinAge(18);
    	j8.setDemo("V7SDsVCyJ_w");
    	j8.setDescription("Disfruta del poder de crear y controlar a personas en un mundo virtual donde no hay reglas. Expresa tu creatividad personalizando el aspecto y la personalidad de tus Sims, y constrúyeles la casa perfecta. Desarrolla las relaciones de tus Sims, asígnales profesiones y explora mundos vibrantes");
    	j8.setNationality("USA");
    	j8.setStudio("The Sims Studio");
    	j8.setYear(2014);
    	j8.setVersion("4.0");
    	j8.setImgSource("./assets/img/Sims.jpg");
    	j8.setPlayabality(true);
    	j8.setPlayTime(80);
    	
    	j9.setName("Ratchet & Clank");
    	j9.setMinAge(7);
    	j9.setDemo("CJEa6TnA824");
    	j9.setDescription("¡El remake basado en la película que está basada en el juego! Únete a Ratchet y Clank y soporta el ego del Capitán Qwark en una aventura intergaláctica para salvar la galaxia de Solana.");
    	j9.setNationality("USA");
    	j9.setStudio("Insomniac Games");
    	j9.setYear(2015);
    	j9.setVersion("2.42");
    	j9.setImgSource("./assets/img/Ratchet.jpg");
    	j9.setPlayabality(true);
    	j9.setPlayTime(60);
    
    	j10.setName("Rocket League");
    	j10.setMinAge(3);
    	j10.setDemo("iwTvsPfYCRA");
    	j10.setDescription("El juego se asemeja al fútbol, pero utilizando vehículos en lugar de jugadores y una pelota de gran tamaño. En los partidos pueden participar desde 1 vs 1 hasta 4 vs 4 jugadores distribuidos en dos equipos, naranja y azul. Cada vehículo puede utilizar propulsión extra, tanto para acelerar como para desplazarse por el aire, siendo esta una característica fundamental del juego.");
    	j10.setNationality("USA");
    	j10.setStudio("Psyonix");
    	j10.setYear(2015);
    	j10.setVersion("1.42");
    	j10.setImgSource("./assets/img/Rocket.jpg");
    	j10.setPlayabality(true);
    	j10.setPlayTime(70);
    	
    	j11.setName("Mario + Rabbids King");
    	j11.setMinAge(7);
    	j11.setDemo("-Bjfefm-8sM");
    	j11.setDescription("Dos mundos colisionan para alborozo de los fans de Mario y los Rabbids en Mario + Rabbids® Kingdom Battle, una descacharrante aventura exclusiva para Nintendo Switch. Un equipo de héroes de lo más dispar y disparatado tendrá como misión restaurar el orden establecido en el Reino Champiñón y luchar en extraños mundos rebosantes de combates por turnos, desafiantes puzles e impredecibles enemigos.");
    	j11.setNationality("France");
    	j11.setStudio("Ubisoft");
    	j11.setYear(2017);
    	j11.setVersion("3.42");
    	j11.setImgSource("./assets/img/Mario.jpg");
    	j11.setPlayabality(true);
    	j11.setPlayTime(0);
    	
    	j12.setName("Kingdom Hearts III");
    	j12.setMinAge(18);
    	j12.setDemo("c2gotXHPL7o");
    	j12.setDescription("Kingdom Hearts 3 es el tercer título de una saga que vuelve a PlayStation 4. Sora seguirá siendo el protagonista y deberemos librar una nueva lucha para mantener el poder de la luz lidiando contra el malvado Maestro Xehanort. Square Enix y Disney brindan al jugador un casting cargado de personajes tan conocidos como Donald, Goofy, Mickey o Riku que se dividirán en dos grupos para avanzar en la aventura.");
    	j12.setNationality("Japan");
    	j12.setStudio("Square Enix");
    	j12.setYear(2018);
    	j12.setVersion("Beta");
    	j12.setImgSource("./assets/img/Kingdom.png");
    	j12.setPlayabality(true);
    	j12.setPlayTime(20);
    	
    	j13.setName("Assassin's Creed Origins");
    	j13.setMinAge(18);
    	j13.setDemo("uq7mgBf-mUE");
    	j13.setDescription("Cuando todo termina, hay un comienzo. Egipto está al borde del colapso. Poderosos monarcas luchan entre sí para disputarse el reino, mientras que otras figuras ocultas acechan entre las sombras listas para hacerse el control.");
    	j13.setNationality("France");
    	j13.setStudio("Ubisofts");
    	j13.setYear(2017);
    	j13.setVersion("1.42");
    	j13.setImgSource("./assets/img/Assassin.jpg");
    	j13.setPlayabality(true);
    	j13.setPlayTime(10);
    	
    	j14.setName("Counter Strike Global Offensive");
    	j14.setMinAge(18);
    	j14.setDemo("IrFqg1SLNGo");
    	j14.setDescription("Counter-Strike: Global Offensive es un videojuego de disparos en primera persona desarrollado por Valve Corporation en cooperación con Hidden Path Entertainment, y es el cuarto juego de la saga Counter-Strike");
    	j14.setNationality("USA");
    	j14.setStudio("Valve Corportatioh");
    	j14.setYear(2012);
    	j14.setVersion("7.42");
    	j14.setImgSource("./assets/img/CSGO.jpg");
    	j14.setPlayabality(true);
    	j14.setPlayTime(50);
    	
    	j15.setName("Gran Turismo Sport");
    	j15.setMinAge(3);
    	j15.setDemo("majgYWNH2yw");
    	j15.setDescription("Pisa el acelerador para disfrutar del simulador de carreras más auténtico y espectacular que has visto jamás: GT Sport");
    	j15.setNationality("Japan");
    	j15.setStudio("Polyphony Digital");
    	j15.setYear(2017);
    	j15.setVersion("1.42");
    	j15.setImgSource("./assets/img/gt.jpg");
    	j15.setPlayabality(true);
    	j15.setPlayTime(10);
    	
    	j16.setName("Minecraft");
    	j16.setMinAge(18);
    	j16.setDemo("nYl27qnKV_Q");
    	j16.setDescription("Minecraft es un juego de construcción, aventura y supervivencia. Su gran libertad de acción y la posibilidad de personalizarlo con pieles y mods dotan a este juego de una vida casi infinita");
    	j16.setNationality("Sweeden");
    	j16.setStudio("Mojang AB");
    	j16.setYear(2011);
    	j16.setVersion("1.31");
    	j16.setImgSource("./assets/img/minecraft.jpg");
    	j16.setPlayabality(true);
    	j16.setPlayTime(40);
    	
    	j17.setName("Shadow of the colossus");
    	j17.setMinAge(12);
    	j17.setDemo("Q1bFx3mW_s8");
    	j17.setDescription("En Shadow of the Colossus encarnaremos una vez más a Wander, siendo nuestra misión encontrar a los 16 colosos de piedra repartidos por el mundo para salvar a mono de su interminable sueño");
    	j17.setNationality("USA");
    	j17.setStudio("Bluepoint Games");
    	j17.setYear(2018);
    	j17.setVersion("1.32");
    	j17.setImgSource("./assets/img/Shadow.png");
    	j17.setPlayabality(true);
    	j17.setPlayTime(70);
    	
    	j18.setName("Horizon: Zero Dawn");
    	j18.setMinAge(16);
    	j18.setDemo("FNhICyLcv14");
    	j18.setDescription("Repudiada por su tribu al nacer, Aloy ha pasado toda su vida buscando respuestas a antiguos secretos y preguntas prohibidas. En una época en la que la humanidad ya no es la especie dominante y seres mecánicos con forma animal nos han arrebatado el control, la joven cazadora se embarcará en un viaje a través de un gigantesco mundo abierto post-apocalíptico para descubrir por qué la Tierra ya no nos pertenece");
    	j18.setNationality("Netherlands");
    	j18.setStudio("Guerrilla Games");
    	j18.setYear(2017);
    	j18.setVersion("2.82");
    	j18.setImgSource("./assets/img/Horizon.jpg");
    	j18.setPlayabality(true);
    	j18.setPlayTime(20);
    	
    	j19.setName("La Tierra Media: Sombras de Guerra");
    	j19.setMinAge(18);
    	j19.setDemo("YotDsiNqbWQ");
    	j19.setDescription("El señor oscuro ha regresado a la Tierra Media para reunir a sus ejércitos y gobernarlos a todos. La historia de Talion y Celebrimbor no ha terminado todavía ya que el conflicto está próximo, una guerra por Mordor ha comenzado.");
    	j19.setNationality("USA");
    	j19.setStudio("Monolith Productions");
    	j19.setYear(2017);
    	j19.setVersion("1.5");
    	j19.setImgSource("./assets/img/Sombras.jpg");
    	j19.setPlayabality(true);
    	j19.setPlayTime(30);
    	
    	j20.setName("Resident Evil 6");
    	j20.setMinAge(18);
    	j20.setDemo("N5sVAZIwtQ8");
    	j20.setDescription("El imparable Virus-C se ha desencadenado en un mundo desprevenido y desde Norteamérica a Europa del Este y China se están produciendo horribles mutaciones mortales.");
    	j20.setNationality("Japan");
    	j20.setStudio("Capcom");
    	j20.setYear(2016);
    	j20.setVersion("1.03");
    	j20.setImgSource("./assets/img/resident.jpg");
    	j20.setPlayabality(true);
    	j20.setPlayTime(80);
    	
    	j21.setName("The Legend of Zelda : Breath of the Wild");
    	j21.setMinAge(18);
    	j21.setDemo("tqcyR3uFigY");
    	j21.setDescription("The Legend of Zelda: Breath of the Wild te sumergirá en un mundo de descubrimiento con un impresionante estilo artístico similar a The Wind Waker o Skyward Sword, una cautivadora banda sonora y una intrigante y melancólica historia.");
    	j21.setNationality("Japan");
    	j21.setStudio("Capcom");
    	j21.setYear(2017);
    	j21.setVersion("1.2");
    	j21.setImgSource("./assets/img/Zelda.jpg");
    	j21.setPlayabality(true);
    	j21.setPlayTime(90);
    	
    	j22.setName("Crash Bandicoot N.Sane Trilogy");
    	j22.setMinAge(12);
    	j22.setDemo("1apjtnEk_KA");
    	j22.setDescription("Acompaña de nuevo a Crash saltando, girando y comiendo Frutas Wumpa mientras haces frente a épicos desafíos y aventuras a través de los tres juegos de plataformas que iniciaron la saga, ahora remasterizados en alta definición");
    	j22.setNationality("Japan");
    	j22.setStudio("Monolith Soft");
    	j22.setYear(2017);
    	j22.setVersion("2.1");
    	j22.setImgSource("./assets/img/crash.jpg");
    	j22.setPlayabality(true);
    	j22.setPlayTime(0);
    	
    	j23.setName("Star Wars Battlefront II");
    	j23.setMinAge(18);
    	j23.setDemo("W6OIKNsT0OA");
    	j23.setDescription("Corre al frente de la batalla en la esperada secuela del título de acción multijugador de DICE basado en la Guerra de las Galaxias.");
    	j23.setNationality("Sweeden");
    	j23.setStudio("EA Dice");
    	j23.setYear(2017);
    	j23.setVersion("1.8");
    	j23.setImgSource("./assets/img/StarWars.jpg");
    	j23.setPlayabality(true);
    	j23.setPlayTime(10);
    	
    	j24.setName("Just Dance 2018");
    	j24.setMinAge(3);
    	j24.setDemo("Gjgc2ODn9iY");
    	j24.setDescription("No importa de dónde eres, qué edad tienes, si eres un panda o una zanahoria... ¡Sube el volumen y saca al bailarín que llevas dentro porque Just Dance 2018 hace bailar a todo el mundo!");
    	j24.setNationality("France");
    	j24.setStudio("EA Paris");
    	j24.setYear(2015);
    	j24.setVersion("1.42");
    	j24.setImgSource("./assets/img/dance.jpg");
    	j24.setPlayabality(true);
    	j24.setPlayTime(60);
    	
    	u.setUsername("Admin");
    	u.setPassword("admin");
    	u.setName("Federico");
    	u.setSurname("Garcia Lorca");
    	u.setEmail("fedeLorca@gmail.com");
    	u.setBirthDate("5/06/1989");
    	u.setCity("Fuente Vaqueros");
    	u.setCountry("España");
    	u.setIsAdmin(1);
    	
    	u1.setUsername("Paco-Gamer");
    	u1.setPassword("1234");
    	u.setName("Miguel");
    	u.setSurname("Hernandez Gilabert");
    	u.setEmail("m.her@gmail.com");
    	u.setBirthDate("30/10/1910");
    	u.setCity("Orihuela");
    	u.setCountry("España");
    	u1.setIsAdmin(0);

    	
    	this.uRepository.save(u);
    	this.uRepository.save(u1);
    	this.gRepository.save(j1);
    	this.gRepository.save(j2);
    	this.gRepository.save(j3);
    	this.gRepository.save(j4);
    	this.gRepository.save(j5);
    	this.gRepository.save(j6);
    	this.gRepository.save(j7);
    	this.gRepository.save(j8);
    	this.gRepository.save(j9);
    	this.gRepository.save(j10);
    	this.gRepository.save(j11);
    	this.gRepository.save(j12);
    	this.gRepository.save(j13);
    	this.gRepository.save(j14);
    	this.gRepository.save(j15);
    	this.gRepository.save(j16);
    	this.gRepository.save(j17);
    	this.gRepository.save(j18);
    	this.gRepository.save(j19);
    	this.gRepository.save(j20);
    	this.gRepository.save(j21);
    	this.gRepository.save(j22);
    	this.gRepository.save(j23);
    	this.gRepository.save(j24);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody Login user ,HttpServletRequest request){
    	IntentoConexion ic = new IntentoConexion();
    	Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd" );
    	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    	ic.setUsername(user.getUsername());
    	ic.setDate(dateFormat.format(date));
    	ic.setTime(timeFormat.format(date));
    	ic.setIP(request.getRemoteAddr());
    	System.out.println(user.getUsername());
    	
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
        			 attempts=0;
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
    public ResponseEntity<Juego> newGame(@RequestBody Juego juego){
    	Juego j = new Juego();
    	j.setName(juego.getName());
    	j.setMinAge(juego.getMinAge());
    	j.setYear(juego.getYear());
    	j.setStudio(juego.getStudio());
    	j.setVersion(juego.getVersion());
    	j.setNationality(juego.getNationality());
    	j.setDescription(juego.getDescription());
    	j.setDemo(juego.getDemo());
    	j.setImgSource(juego.getImgSource());
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
    public ResponseEntity<Juego> updateGame(@PathVariable Long id,@RequestBody Juego juego) {
    	Juego j = this.gRepository.findByIdGame(id);
    	if (j == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND );    	
    	}
    	String name = juego.getName();
    	Integer year = juego.getYear();
    	Integer minAge = juego.getMinAge();
    	String studio = juego.getStudio();
    	String version = juego.getVersion();
    	String nationality = juego.getNationality();
    	String description = juego.getDescription();
    	String demo = juego.getDemo();
    	System.out.println(juego.getStudio());
    	
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
