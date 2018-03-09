import { Injectable } from '@angular/core';
import { Card } from '../objects/card';

@Injectable()
export class PlotLoaderService {

  constructor() { }
  public getXAxis() {
    return [
     'Veces jugada la demo',
     'Veces terminada la demo',
     'Veces Comprado el juego'
    ];
  }
  public getSeriesData() {
    return [
      {
      name: 'Call of Duty: WWII',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    },
     {
      name: 'Fifa 18',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Fortnite',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Dragon Ball FighterZ',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Monster Hunter World',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'The Last Of Us',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'The Binding of Isaac: Afterbirth',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Los Sims 4',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Ratchet & Clank',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Rocket League',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Mario + Rabbids King',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Kingdom Hearts III',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Assassin\'s Creed Origins',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Counter Strike Global Offensive',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Gran Turismo Sport',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Minecraft',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Shadow of the colossus',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Horizon: Zero Dawn',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'La Tierra Media: Sombras de Guerra',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Resident Evil 6',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'The Legend of Zelda : Breath of the Wild',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Crash Bandicoot N.Sane Trilogy',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Star Wars Battlefront II',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
    }, {
      name: 'Just Dance 2018',
      data: [{
          name: 'Veces jugada la demo',
          y: Math.floor(Math.random() * (5000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces terminada la demo',
          y: Math.floor(Math.random() * (4000 - 2000 + 1) + 2000)
      }, {
          name: 'Veces comprado el juego',
          y: Math.floor(Math.random() * (1000 - 50 + 1) + 50)
      }]
  }
  ];
  }
}
