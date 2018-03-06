import { Component, ViewChild, ViewChildren} from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { Card } from './objects/card';
import { NgModel, NgForm } from '@angular/forms';
import { GameLoaderService } from './services/game-loader.service';
import { OwlCarousel } from 'ngx-owl-carousel';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { NgbModalOptions } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { NgbTypeahead } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import { NgbProgressbarConfig } from '@ng-bootstrap/ng-bootstrap/';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap/modal/modal-ref';
import { Chart } from 'angular-highcharts';
import { PlotLoaderService } from './services/plot-loader.service';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'PSSII-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  // @ViewChildren('owlElement') owlElement: OwlCarousel[];
  public tempConfig;
  public admin: boolean;
  private modal: NgbModalRef;
  public games: Card[];
  public searchInput: string;
  private closeResult: string;
  public chart;

  constructor(private service: GameLoaderService,
    private modalService: NgbModal, private config: NgbProgressbarConfig, private plot: PlotLoaderService) {}

  ngOnInit() {
    const options = {
      chart: {
        type: 'column'
      },
      title: {
        text: 'Estadisticas de juego'
      },
      credits: {
        enabled: true
      },
      legend: {
        enabled: true
      },
      yAxis: {
        min: 0,
        title: {
            text: 'Nº veces'
        }
      },
      xAxis: {
        categories: this.plot.getXAxis(),
        crosshair: true
      },
      plotOptions: {
          series: {
              borderWidth: 0,
              dataLabels: {
                  enabled: true,
                  format: '{point.y} veces'
              }
          }
      },
      series: this.plot.getSeriesData()
    };
    this.games = this.service.getGames();
    this.config.striped = true;
    this.config.animated = true;
    this.config.max = 100;
    this.chart = new Chart(options);


    // this.owlElement.reInit();
  }
  checkArrayEmpty(): boolean {
    return this.games.filter(item => item.title.indexOf(this.searchInput) !== -1).length === 0;
  }
  public heySoyUnBoton(content) {
    const options: NgbModalOptions = {};
    options.size = 'lg';
    options.windowClass = 'modal';
    this.modal = this.modalService.open(content, options);
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  public evento(eventito, game) {
    switch (eventito.data) {
      case -1: {
        this.tempConfig = eventito.target.getDuration();
        console.log(this.tempConfig);

      }
        break;
      case 0: {
        this.tempConfig = eventito.target.getDuration();
        this.games[game].playTime = eventito.target.getDuration();
        // this.modal.close();
        this.games[game].playability = false;
        console.log(this.tempConfig);

      }
        break;
      case 1: {
        (eventito.target.getCurrentTime() < this.games[game].playTime) ?
          eventito.target.seekTo(this.games[game].playTime) :
          this.games[game].playTime = eventito.target.getCurrentTime();
        break;
      }
      case 2: {
        this.games[game].playTime = (eventito.target.getCurrentTime() > this.games[game].playTime) ?
          eventito.target.getCurrentTime() :
          this.games[game].playTime;
          eventito.target.seekTo(this.games[game].playTime);
      }
        break;

      default:
        break;
    }
  }
  public checkPlayability(game, player): boolean {
    return this.games[game].playTime < player.getDuration();
  }
  public showDisabled(t, i) {
    if (!this.games[i].playability) {
      t.open();
    }

  }

  search = (text$: Observable<string>) =>
    text$
      .debounceTime(200)
      .distinctUntilChanged()
      .map(term => term.length < 1 ? []
        : this.games.filter(v => v.title.toLowerCase().indexOf(term.toLowerCase()) > -1).map(v => v.title).slice(0, 4))
}
