import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {MessageComponent} from './message/message.component';
import {WallComponent} from './wall/wall.component';
import {TimelineComponent} from './timeline/timeline.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'message',
    component: MessageComponent,
  },
  {
    path: 'wall',
    component: WallComponent,
  },
  {
    path: 'timeline',
    component: TimelineComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
