import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { Card } from './objects/card';
import { NgModel, NgForm } from '@angular/forms';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'PSSII-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  public games: Card[];
  public searchInput: string;
  constructor() {}
  ngOnInit() {
    this.games = [{
      title: 'Call of Duty: WWII',
      description: 'Call of Duty vuelve a sus raíces con WWII, el regreso de la serie de acción en primera persona a la Segunda Guerra Mundial. Desde las frías aguas de Normandía en el día D, avanzarás por todo el frente europeo enfrentándote al eje y defendiendo la libertad en un mundo al borde de la tiranía. Vive una historia de hermandad entre soldados en la mayor campaña ambientada en la Segunda Guerra Mundial, participa en algunas de las batallas más icónicas del conflicto en el brutal y realista modo multijugador en línea o coopera ante la amenaza de muertos vivientes en la historia independiente del nuevo modo zombies.',
      imgSource: '../assets/img/cod.jpg'
    },
    {
      title: 'Fifa 18',
      description: '¿Estás preparado para tu temporada más importante hasta la fecha? Gracias al motor Frostbite, FIFA 18 hace que se confunda la línea que separa el mundo virtual del real, y consigue darle vida a los héroes, a los equipos y a las atmósferas que se viven en los partidos de verdad.',
      imgSource: '../assets/img/fifa18.jpg'
    },
    {
      title: 'Fortnite',
      description: 'Fortnite es un juego de Epic Games que nos reta a buscar recursos en un mundo durante el día, y a sobrevivir durante la noche a los ataques de los seres fantásticos que lo pueblan y aprovechan la oscuridad para fortalecerse. El juego cuenta con elementos cooperativos, y podremos construir estructuras fortificadas, luchar contra oleadas de enemigos, y construir objetos.',
      imgSource: '../assets/img/fortnite.jpg'
    },
    {
      title: 'Dragon Ball FighterZ',
      description: 'Vuelve la acción con Dragon Ball FighterZ, el juego de lucha 2D definitivo que te convertirá en el mejor guerrero del universo. Tras el éxito de Xenoverse, llega un nuevo Dragon Ball que mejora al máximo los gráficos del anime, con una mecánica fácil de aprender pero... Difícil de dominar. Dragon Ball FighterZ viene con todo el contenido que ha hecho que las series Dragon Ball sean tan apreciadas por el público. Espectaculares enfrentamientos sin fin con luchadores extremadamente poderosos',
      imgSource: '../assets/img/db.jpg'
    },
    {
      title: 'Monster Hunter World',
      description: 'Empuña de nuevo tu Gran Espada y adéntrate en el "Nuevo Mundo" para dar caza a los monstruos más feroces jamás conocidos. Tras 9 años desde su última aparición en consolas de sobremesa, la saga Monster Hunter, producida por Ryozo Tsujimoto, regresa con el título Monster Hunter World, la nueva entrega de caza lanzada de manera simultánea en todo el mundo',
      imgSource : '../assets/img/MonsterHunterWorld.png'
    },
    {
      title: 'The Last Of Us',
      description: 'descript',
      imgSource : '../assets/img/Last.jpg'
    },
    {
      title: 'The Binding of Isaac: Afterbirth ',
      description: 'descript',
      imgSource: '../assets/img/Isaac.jpg'
    },
    {
      title: 'Los Sims 4',
      description: 'descript',
      imgSource: '../assets/img/Sims.jpg'
    },
    {
      title: 'tercer',
      description: 'descript'
    },
    {
      title: 'primerisimo',
      description: 'descript'
    },
    {
      title: 'segundo',
      description: 'descript'
    },
    {
      title: 'tercer',
      description: 'descript'
    },
    {
      title: 'primerisimo',
      description: 'descript'
    },
    {
      title: 'segundo',
      description: 'descript'
    },
    {
      title: 'tercer',
      description: 'descript'
    },
    {
      title: 'primerisimo',
      description: 'descript'
    },
    {
      title: 'segundo',
      description: 'descript'
    },
    {
      title: 'tercer',
      description: 'descript'
    },
    {
      title: 'primerisimo',
      description: 'descript'
    },
    {
      title: 'segundo',
      description: 'descript'
    },
    {
      title: 'tercer',
      description: 'descript'
    },
    {
      title: 'primerisimo',
      description: 'descript'
    },
    {
      title: 'segundo',
      description: 'descript'
    },
    {
      title: 'tercer',
      description: 'descript'
    }];


  }
  checkArrayEmpty(): boolean {
    return this.games.filter(item => item.title.indexOf(this.searchInput) !== -1).length === 0;
  }
}
