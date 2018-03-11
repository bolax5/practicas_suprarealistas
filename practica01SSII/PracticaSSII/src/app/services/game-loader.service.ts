import { Injectable } from '@angular/core';
import { Card } from '../objects/card';
import { Observable } from 'rxjs/Observable';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';

@Injectable()
export class GameLoaderService {
  private games: Card[];
  constructor(private sanit: DomSanitizer) { }
  public getGames(): Card[] {

    this.games = [{
      title: 'Call of Duty: WWII',
      // tslint:disable-next-line:max-line-length
      description: 'Call of Duty vuelve a sus raíces con WWII, el regreso de la serie de acción en primera persona a la Segunda Guerra Mundial. Desde las frías aguas de Normandía en el día D, avanzarás por todo el frente europeo enfrentándote al eje y defendiendo la libertad en un mundo al borde de la tiranía. Vive una historia de hermandad entre soldados en la mayor campaña ambientada en la Segunda Guerra Mundial, participa en algunas de las batallas más icónicas del conflicto en el brutal y realista modo multijugador en línea o coopera ante la amenaza de muertos vivientes en la historia independiente del nuevo modo zombies.',
      imgSource: './assets/img/cod.jpg',
      studio: 'Sledgehammer Games',
      nationality: 'USA',
      minAge: 18,
      videoSource: '4h7joJnMeb4',
      playability: true,
      playTime: 100
    },
    {
      title: 'Fifa 18',
      // tslint:disable-next-line:max-line-length
      description: '¿Estás preparado para tu temporada más importante hasta la fecha? Gracias al motor Frostbite, FIFA 18 hace que se confunda la línea que separa el mundo virtual del real, y consigue darle vida a los héroes, a los equipos y a las atmósferas que se viven en los partidos de verdad.',
      imgSource: './assets/img/fifa18.jpg',
      studio: 'EA Sports',
      nationality: 'Canada',
      minAge: 3,
      videoSource: 'fFKGXz3k9VU',
      playability: true,
      playTime: 50
    },
    {
      title: 'Fortnite',
      // tslint:disable-next-line:max-line-length
      description: 'Fortnite es un juego de Epic Games que nos reta a buscar recursos en un mundo durante el día, y a sobrevivir durante la noche a los ataques de los seres fantásticos que lo pueblan y aprovechan la oscuridad para fortalecerse. El juego cuenta con elementos cooperativos, y podremos construir estructuras fortificadas, luchar contra oleadas de enemigos, y construir objetos.',
      imgSource: './assets/img/fortnite.jpg',
      videoSource: 'JwD8foebcFs',
      playability: true,
      playTime: 20
    },
    {
      title: 'Dragon Ball FighterZ',
      // tslint:disable-next-line:max-line-length
      description: 'Vuelve la acción con Dragon Ball FighterZ, el juego de lucha 2D definitivo que te convertirá en el mejor guerrero del universo. Tras el éxito de Xenoverse, llega un nuevo Dragon Ball que mejora al máximo los gráficos del anime, con una mecánica fácil de aprender pero... Difícil de dominar. Dragon Ball FighterZ viene con todo el contenido que ha hecho que las series Dragon Ball sean tan apreciadas por el público. Espectaculares enfrentamientos sin fin con luchadores extremadamente poderosos',
      imgSource: './assets/img/db.jpg',
      videoSource: 'ZGKXvvqeBuA',
      playability: true,
      playTime: 30
    },
    {
      title: 'Monster Hunter World',
      // tslint:disable-next-line:max-line-length
      description: 'Empuña de nuevo tu Gran Espada y adéntrate en el "Nuevo Mundo" para dar caza a los monstruos más feroces jamás conocidos. Tras 9 años desde su última aparición en consolas de sobremesa, la saga Monster Hunter, producida por Ryozo Tsujimoto, regresa con el título Monster Hunter World, la nueva entrega de caza lanzada de manera simultánea en todo el mundo',
      imgSource: './assets/img/MonsterHunterWorld.png',
      videoSource: 'oC8y2THEV7E',
      playability: true,
      playTime: 10
    },
    {
      title: 'The Last Of Us',
      // tslint:disable-next-line:max-line-length
      description: 'En un mundo hostil y post-pandémico, las circunstancias desesperadas acaban uniendo a Ellie y Joel, quienes deben confiar el uno en el otro para sobrevivir en un viaje salvaje por lo que queda de Estados Unidos.',
      imgSource: './assets/img/Last.jpg',
      videoSource: '6Mg3Y2BVR38',
      playability: true,
      playTime: 50
    },
    {
      title: 'The Binding of Isaac: Afterbirth ',
      // tslint:disable-next-line:max-line-length
      description: 'The Binding of Isaac: Afterbirth+ es un juego de acción en vista cenital, con grandes dosis de elementos RPG y Rogue-like en el que los mundos se generan de manera aleatoria, dando lugar a probabilidades casi infinitas',
      imgSource: './assets/img/Isaac.jpg',
      videoSource: 'cvxVriP5Dvk',
      nationality: 'USA',
      minAge: 18,
      studio: 'Pepito',
      playability: true,
      playTime: 10
    },
    {
      title: 'Los Sims 4',
      // tslint:disable-next-line:max-line-length
      description: 'Disfruta del poder de crear y controlar a personas en un mundo virtual donde no hay reglas. Expresa tu creatividad personalizando el aspecto y la personalidad de tus Sims, y constrúyeles la casa perfecta. Desarrolla las relaciones de tus Sims, asígnales profesiones y explora mundos vibrantes',
      imgSource: './assets/img/Sims.jpg',
      videoSource: 'V7SDsVCyJ_w',
      playability: true,
      playTime: 80
    },
    {
      title: 'Ratchet & Clank',
      // tslint:disable-next-line:max-line-length
      description: '¡El remake basado en la película que está basada en el juego! Únete a Ratchet y Clank y soporta el ego del Capitán Qwark en una aventura intergaláctica para salvar la galaxia de Solana.',
      imgSource: './assets/img/Ratchet.jpg',
      videoSource: 'CJEa6TnA824',
      playability: true,
      playTime: 60
    },
    {
      title: 'Rocket League',
      // tslint:disable-next-line:max-line-length
      description: 'El juego se asemeja al fútbol, pero utilizando vehículos en lugar de jugadores y una pelota de gran tamaño. En los partidos pueden participar desde 1 vs 1 hasta 4 vs 4 jugadores distribuidos en dos equipos, naranja y azul. Cada vehículo puede utilizar propulsión extra, tanto para acelerar como para desplazarse por el aire, siendo esta una característica fundamental del juego.',
      imgSource: './assets/img/Rocket.jpg',
      videoSource: 'iwTvsPfYCRA',
      playability: true,
      playTime: 70
    },
    {
      title: 'Mario + Rabbids King',
      // tslint:disable-next-line:max-line-length
      description: 'Dos mundos colisionan para alborozo de los fans de Mario y los Rabbids en Mario + Rabbids® Kingdom Battle, una descacharrante aventura exclusiva para Nintendo Switch. Un equipo de héroes de lo más dispar y disparatado tendrá como misión restaurar el orden establecido en el Reino Champiñón y luchar en extraños mundos rebosantes de combates por turnos, desafiantes puzles e impredecibles enemigos.',
      imgSource: './assets/img/Mario.jpg',
      videoSource: '-Bjfefm-8sM',
      playability: true,
      playTime: 0
    },
    {
      title: 'Kingdom Hearts III',
      // tslint:disable-next-line:max-line-length
      description: 'Kingdom Hearts 3 es el tercer título de una saga que vuelve a PlayStation 4. Sora seguirá siendo el protagonista y deberemos librar una nueva lucha para mantener el poder de la luz lidiando contra el malvado Maestro Xehanort. Square Enix y Disney brindan al jugador un casting cargado de personajes tan conocidos como Donald, Goofy, Mickey o Riku que se dividirán en dos grupos para avanzar en la aventura.',
      imgSource: './assets/img/Kingdom.png',
      videoSource: 'c2gotXHPL7o',
      playability: true,
      playTime: 20
    },
    {
      title: 'Assassin\'s Creed Origins',
      // tslint:disable-next-line:max-line-length
      description: 'Cuando todo termina, hay un comienzo. Egipto está al borde del colapso. Poderosos monarcas luchan entre sí para disputarse el reino, mientras que otras figuras ocultas acechan entre las sombras listas para hacerse el control.',
      imgSource: './assets/img/Assassin.jpg',
      videoSource: 'uq7mgBf-mUE',
      playability: true,
      playTime: 10
    },
    {
      title: 'Counter Strike Global Offensive',
      // tslint:disable-next-line:max-line-length
      description: 'Counter-Strike: Global Offensive es un videojuego de disparos en primera persona desarrollado por Valve Corporation en cooperación con Hidden Path Entertainment, y es el cuarto juego de la saga Counter-Strike',
      imgSource: './assets/img/CSGO.jpg',
      videoSource: 'IrFqg1SLNGo',
      playability: true,
      playTime: 50
    },
    {
      title: 'Gran Turismo Sport',
      // tslint:disable-next-line:max-line-length
      description: 'Pisa el acelerador para disfrutar del simulador de carreras más auténtico y espectacular que has visto jamás: GT Sport',
      imgSource: './assets/img/gt.jpg',
      videoSource: 'majgYWNH2yw',
      playability: true,
      playTime: 10
    },
    {
      title: 'Minecraft',
      // tslint:disable-next-line:max-line-length
      description: 'Minecraft es un juego de construcción, aventura y supervivencia. Su gran libertad de acción y la posibilidad de personalizarlo con pieles y mods dotan a este juego de una vida casi infinita',
      imgSource: './assets/img/minecraft.jpg',
      videoSource: 'nYl27qnKV_Q',
      playability: true,
      playTime: 40
    },
    {
      title: 'Shadow of the colossus',
      // tslint:disable-next-line:max-line-length
      description: 'En Shadow of the Colossus encarnaremos una vez más a Wander, siendo nuestra misión encontrar a los 16 colosos de piedra repartidos por el mundo para salvar a mono de su interminable sueño',
      imgSource: './assets/img/Shadow.png',
      videoSource: 'Q1bFx3mW_s8',
      playability: true,
      playTime: 70
    },
    {
      title: 'Horizon: Zero Dawn',
      // tslint:disable-next-line:max-line-length
      description: 'Repudiada por su tribu al nacer, Aloy ha pasado toda su vida buscando respuestas a antiguos secretos y preguntas prohibidas. En una época en la que la humanidad ya no es la especie dominante y seres mecánicos con forma animal nos han arrebatado el control, la joven cazadora se embarcará en un viaje a través de un gigantesco mundo abierto post-apocalíptico para descubrir por qué la Tierra ya no nos pertenece',
      imgSource: './assets/img/Horizon.jpg',
      videoSource: 'FNhICyLcv14',
      playability: true,
      playTime: 20
    },
    {
      title: 'La Tierra Media: Sombras de Guerra',
      // tslint:disable-next-line:max-line-length
      description: 'El señor oscuro ha regresado a la Tierra Media para reunir a sus ejércitos y gobernarlos a todos. La historia de Talion y Celebrimbor no ha terminado todavía ya que el conflicto está próximo, una guerra por Mordor ha comenzado.',
      imgSource: './assets/img/Sombras.jpg',
      videoSource: 'YotDsiNqbWQ',
      playability: true,
      playTime: 30
    },
    {
      title: 'Resident Evil 6',
      // tslint:disable-next-line:max-line-length
      description: 'El imparable Virus-C se ha desencadenado en un mundo desprevenido y desde Norteamérica a Europa del Este y China se están produciendo horribles mutaciones mortales.',
      imgSource: './assets/img/resident.jpg',
      videoSource: 'N5sVAZIwtQ8',
      playability: true,
      playTime: 80
    },
    {
      title: 'The Legend of Zelda : Breath of the Wild',
      // tslint:disable-next-line:max-line-length
      description: 'The Legend of Zelda: Breath of the Wild te sumergirá en un mundo de descubrimiento con un impresionante estilo artístico similar a The Wind Waker o Skyward Sword, una cautivadora banda sonora y una intrigante y melancólica historia.',
      imgSource: './assets/img/Zelda.jpg',
      videoSource: 'tqcyR3uFigY',
      playability: true,
      playTime: 90
    },
    {
      title: 'Crash Bandicoot N.Sane Trilogy',
      // tslint:disable-next-line:max-line-length
      description: 'Acompaña de nuevo a Crash saltando, girando y comiendo Frutas Wumpa mientras haces frente a épicos desafíos y aventuras a través de los tres juegos de plataformas que iniciaron la saga, ahora remasterizados en alta definición',
      imgSource: './assets/img/crash.jpg',
      videoSource: '1apjtnEk_KA',
      playability: true,
      playTime: 0
    },
    {
      title: 'Star Wars Battlefront II',
      // tslint:disable-next-line:max-line-length
      description: 'Corre al frente de la batalla en la esperada secuela del título de acción multijugador de DICE basado en la Guerra de las Galaxias.',
      imgSource: './assets/img/StarWars.jpg',
      videoSource: 'W6OIKNsT0OA',
      playability: true,
      playTime: 10
    },
    {
      title: 'Just Dance 2018',
      // tslint:disable-next-line:max-line-length
      description: 'No importa de dónde eres, qué edad tienes, si eres un panda o una zanahoria... ¡Sube el volumen y saca al bailarín que llevas dentro porque Just Dance 2018 hace bailar a todo el mundo!',
      imgSource: './assets/img/dance.jpg',
      videoSource: 'Gjgc2ODn9iY',
      playability: true,
      playTime: 60
    }];
    return this.games;
  }
}
