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
      description: 'descript',
      imgSource: '../assets/img/cod.jpg'
    },
    {
      title: 'Fifa 18',
      description: 'descript',
      imgSource: '../assets/img/fifa18.jpg'
    },
    {
      title: 'Fortnite',
      description: 'descript',
      imgSource: '../assets/img/fortnite.jpg'
    },
    {
      title: 'Dragon Ball FighterZ',
      description: 'descript',
      imgSource: '../assets/img/db.jpg'
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
