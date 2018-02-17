import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FilterGamesPipe } from './pipes/filter-games.pipe';
import { GameLoaderService } from './services/game-loader.service';
import { OwlModule } from 'ngx-owl-carousel';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { NgbTypeahead } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead.module';
import { YoutubePlayerModule } from 'ngx-youtube-player';



@NgModule({
  declarations: [
    AppComponent,
    FilterGamesPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    OwlModule,
    NgbModule.forRoot(),
    NgbTypeaheadModule,
    YoutubePlayerModule
  ],
  providers: [GameLoaderService, NgbModal],
  bootstrap: [AppComponent]
})
export class AppModule { }
