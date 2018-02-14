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
      imgSource: '../assets/img/cod.jpg'
    },
    {
      title: 'Fifa 18',
      // tslint:disable-next-line:max-line-length
      description: '¿Estás preparado para tu temporada más importante hasta la fecha? Gracias al motor Frostbite, FIFA 18 hace que se confunda la línea que separa el mundo virtual del real, y consigue darle vida a los héroes, a los equipos y a las atmósferas que se viven en los partidos de verdad.',
      imgSource: '../assets/img/fifa18.jpg',
      videoSource: this.sanit.bypassSecurityTrustResourceUrl('https://www.youtube.com/embed/fFKGXz3k9VU')
    },
    {
      title: 'Fortnite',
      // tslint:disable-next-line:max-line-length
      description: 'Fortnite es un juego de Epic Games que nos reta a buscar recursos en un mundo durante el día, y a sobrevivir durante la noche a los ataques de los seres fantásticos que lo pueblan y aprovechan la oscuridad para fortalecerse. El juego cuenta con elementos cooperativos, y podremos construir estructuras fortificadas, luchar contra oleadas de enemigos, y construir objetos.',
      imgSource: '../assets/img/fortnite.jpg'
    },
    {
      title: 'Dragon Ball FighterZ',
      // tslint:disable-next-line:max-line-length
      description: 'Vuelve la acción con Dragon Ball FighterZ, el juego de lucha 2D definitivo que te convertirá en el mejor guerrero del universo. Tras el éxito de Xenoverse, llega un nuevo Dragon Ball que mejora al máximo los gráficos del anime, con una mecánica fácil de aprender pero... Difícil de dominar. Dragon Ball FighterZ viene con todo el contenido que ha hecho que las series Dragon Ball sean tan apreciadas por el público. Espectaculares enfrentamientos sin fin con luchadores extremadamente poderosos',
      imgSource: '../assets/img/db.jpg'
    },
    {
      title: 'Monster Hunter World',
      // tslint:disable-next-line:max-line-length
      description: 'Empuña de nuevo tu Gran Espada y adéntrate en el "Nuevo Mundo" para dar caza a los monstruos más feroces jamás conocidos. Tras 9 años desde su última aparición en consolas de sobremesa, la saga Monster Hunter, producida por Ryozo Tsujimoto, regresa con el título Monster Hunter World, la nueva entrega de caza lanzada de manera simultánea en todo el mundo',
      imgSource: '../assets/img/MonsterHunterWorld.png'
    },
    {
      title: 'The Last Of Us',
      // tslint:disable-next-line:max-line-length
      description: 'En un mundo hostil y post-pandémico, las circunstancias desesperadas acaban uniendo a Ellie y Joel, quienes deben confiar el uno en el otro para sobrevivir en un viaje salvaje por lo que queda de Estados Unidos.',
      imgSource: '../assets/img/Last.jpg'
    },
    {
      title: 'The Binding of Isaac: Afterbirth ',
      // tslint:disable-next-line:max-line-length
      description: 'The Binding of Isaac: Afterbirth+ es un juego de acción en vista cenital, con grandes dosis de elementos RPG y Rogue-like en el que los mundos se generan de manera aleatoria, dando lugar a probabilidades casi infinitas',
      imgSource: '../assets/img/Isaac.jpg'
    },
    {
      title: 'Los Sims 4',
      // tslint:disable-next-line:max-line-length
      description: 'Los Sims 4 es un videojuego de simulación social y de vida',
      imgSource: '../assets/img/Sims.jpg'
    },
    {
      title: 'Ratchet & Clank',
      // tslint:disable-next-line:max-line-length
      description: '¡El remake basado en la película que está basada en el juego! Únete a Ratchet y Clank y soporta el ego del Capitán Qwark en una aventura intergaláctica para salvar la galaxia de Solana.',
      imgSource: '../assets/img/Ratchet.jpg'
    },
    {
      title: 'Rocket League',
      // tslint:disable-next-line:max-line-length
      description: 'Rocket League es un videojuego que combina el fútbol con los vehículos.',
      imgSource: '../assets/img/Rocket.jpg'
    },
    {
      title: 'Mario + Rabbids King',
      // tslint:disable-next-line:max-line-length
      description: 'El universo de Super Mario es invadido por los Rabbids en Mario + Rabbids Kingdom Battle!',
      imgSource: '../assets/img/Mario.jpg'
    },
    {
      title: 'Kingdom Hearts III',
      // tslint:disable-next-line:max-line-length
      description: 'Sora, Donald, y Goofy vuelven en una aventura cargada de magia y emoción con Kingdom Hearts III',
      imgSource: '../assets/img/Kingdom.png'
    },
    {
      title: 'Assassin\'s Creed Origins',
      // tslint:disable-next-line:max-line-length
      description: 'Cuando todo termina, hay un comienzo. Egipto está al borde del colapso. Poderosos monarcas luchan entre sí para disputarse el reino, mientras que otras figuras ocultas acechan entre las sombras listas para hacerse el control.',
      imgSource: '../assets/img/Assassin.jpg'
    },
    {
      title: 'Counter Strike Global Offensive',
      // tslint:disable-next-line:max-line-length
      description: 'Counter-Strike: Global Offensive es un videojuego de disparos en primera persona desarrollado por Valve Corporation en cooperación con Hidden Path Entertainment, y es el cuarto juego de la saga Counter-Strike',
      imgSource: '../assets/img/CSGO.jpg'
    },
    {
      title: 'Gran Turismo Sport',
      // tslint:disable-next-line:max-line-length
      description: 'Pisa el acelerador para disfrutar del simulador de carreras más auténtico y espectacular que has visto jamás: GT Sport',
      imgSource: '../assets/img/gt.jpg'
    },
    {
      title: 'Minecraft',
      // tslint:disable-next-line:max-line-length
      description: 'Minecraft es un juego de construcción, aventura y supervivencia. Su gran libertad de acción y la posibilidad de personalizarlo con pieles y mods dotan a este juego de una vida casi infinita',
      imgSource: '../assets/img/minecraft.jpg'
    },
    {
      title: 'Shadow of the colossus',
      // tslint:disable-next-line:max-line-length
      description: 'En Shadow of the Colossus encarnaremos una vez más a Wander, siendo nuestra misión encontrar a los 16 colosos de piedra repartidos por el mundo para salvar a mono de su interminable sueño',
      imgSource: '../assets/img/Shadow.png'
    },
    {
      title: 'Horizon: Zero Dawn',
      // tslint:disable-next-line:max-line-length
      description: 'Repudiada por su tribu al nacer, Aloy ha pasado toda su vida buscando respuestas a antiguos secretos y preguntas prohibidas. En una época en la que la humanidad ya no es la especie dominante y seres mecánicos con forma animal nos han arrebatado el control, la joven cazadora se embarcará en un viaje a través de un gigantesco mundo abierto post-apocalíptico para descubrir por qué la Tierra ya no nos pertenece',
      imgSource: '../assets/img/Horizon.jpg'
    },
    {
      title: 'La Tierra Media: Sombras de Guerra',
      // tslint:disable-next-line:max-line-length
      description: 'El señor oscuro ha regresado a la Tierra Media para reunir a sus ejércitos y gobernarlos a todos. La historia de Talion y Celebrimbor no ha terminado todavía ya que el conflicto está próximo, una guerra por Mordor ha comenzado.',
      imgSource: '../assets/img/Sombras.jpg'

    },
    {
      title: 'Resident Evil 6',
      // tslint:disable-next-line:max-line-length
      description: 'El imparable Virus-C se ha desencadenado en un mundo desprevenido y desde Norteamérica a Europa del Este y China se están produciendo horribles mutaciones mortales.',
      imgSource: '../assets/img/resident.jpg'
    },
    {
      title: 'The Legend of Zelda : Breath of the Wild',
      // tslint:disable-next-line:max-line-length
      description: 'The Legend of Zelda: Breath of the Wild te sumergirá en un mundo de descubrimiento con un impresionante estilo artístico similar a The Wind Waker o Skyward Sword, una cautivadora banda sonora y una intrigante y melancólica historia.',
      imgSource: '../assets/img/Zelda.jpg'
    },
    {
      title: 'Crash Bandicoot N.Sane Trilogy',
      // tslint:disable-next-line:max-line-length
      description: 'Acompaña de nuevo a Crash saltando, girando y comiendo Frutas Wumpa mientras haces frente a épicos desafíos y aventuras a través de los tres juegos de plataformas que iniciaron la saga, ahora remasterizados en alta definición',
      imgSource: '../assets/img/crash.jpg'
    },
    {
      title: 'Star Wars Battlefront II',
      // tslint:disable-next-line:max-line-length
      description: 'Corre al frente de la batalla en la esperada secuela del título de acción multijugador de DICE basado en la Guerra de las Galaxias.',
      imgSource: '../assets/img/StarWars.jpg'
    },
    {
      title: 'Just Dance 2018',
      // tslint:disable-next-line:max-line-length
      description: 'No importa de dónde eres, qué edad tienes, si eres un panda o una zanahoria... ¡Sube el volumen y saca al bailarín que llevas dentro porque Just Dance 2018 hace bailar a todo el mundo!',
      imgSource: '../assets/img/dance.jpg'
    }];
    return this.games;
  }
}
