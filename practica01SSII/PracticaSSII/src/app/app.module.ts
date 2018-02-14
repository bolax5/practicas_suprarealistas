import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FilterGamesPipe } from './pipes/filter-games.pipe';
import { GameLoaderService } from './services/game-loader.service';
import { OwlModule } from 'ngx-owl-carousel';


@NgModule({
  declarations: [
    AppComponent,
    FilterGamesPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    OwlModule
  ],
  providers: [GameLoaderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
