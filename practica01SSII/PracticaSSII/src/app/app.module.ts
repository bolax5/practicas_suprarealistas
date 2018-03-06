import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FilterGamesPipe } from './pipes/filter-games.pipe';
import { GameLoaderService } from './services/game-loader.service';
import { OwlModule } from 'ngx-owl-carousel';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { NgbTypeahead } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead.module';
import { YoutubePlayerModule } from 'ngx-youtube-player';
import { ChartModule } from 'angular-highcharts';
import { PlotLoaderService } from './services/plot-loader.service';
import { LoginComponent } from './login/login.component';
import { BootrsapComponent } from './bootrsap/bootrsap.component';
import { MainComponent } from './main/main.component';
import { LoginService } from './services/login.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    FilterGamesPipe,
    LoginComponent,
    BootrsapComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    OwlModule,
    NgbModule.forRoot(),
    NgbTypeaheadModule,
    YoutubePlayerModule,
    ChartModule,
    HttpClientModule
  ],
  providers: [GameLoaderService, LoginService, NgbModal, PlotLoaderService, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
