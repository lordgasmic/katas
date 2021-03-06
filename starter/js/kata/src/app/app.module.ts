import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { WallComponent } from './wall/wall.component';
import { TimelineComponent } from './timeline/timeline.component';
import { MessageComponent } from './message/message.component';
import { HeaderComponent } from './header/header.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatInputModule} from '@angular/material/input';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, HomeComponent, WallComponent, TimelineComponent, MessageComponent, HeaderComponent],
  imports: [
    HttpClientModule,BrowserModule, AppRoutingModule,MatInputModule,
    MatSnackBarModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
