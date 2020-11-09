import { Component, OnInit } from '@angular/core';
import {MessageResponse} from '../model/MessageResponse';
import {KataService} from '../service/kata.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {
  messages: MessageResponse[];
  waiting = true;

  constructor(private katas: KataService) { }

  ngOnInit(): void {
  }

}
