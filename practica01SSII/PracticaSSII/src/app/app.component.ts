import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { Card } from './objects/card';
import { NgModel, NgForm } from '@angular/forms';
import { GameLoaderService } from './services/game-loader.service';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'PSSII-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  public games: Card[];
  public searchInput: string;
  constructor(private service: GameLoaderService) {}
  ngOnInit() {
    this.games = this.service.getGames();

  }
  checkArrayEmpty(): boolean {
    return this.games.filter(item => item.title.indexOf(this.searchInput) !== -1).length === 0;
  }
}
