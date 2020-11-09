import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {KataService} from '../service/kata.service';
import {Router} from '@angular/router';
import {MessageRequest} from '../model/MessageRequest';
import {ToastMessageService} from '../service/toast-message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  @ViewChild('username') username: ElementRef;
  @ViewChild('message') message: ElementRef;

  constructor(private katas: KataService, private router: Router, private toastMessageService: ToastMessageService) { }

  ngOnInit(): void {
  }

  addMessage():void {
    const un = this.username.nativeElement.value;
    if (un) {
      const messageRequest : MessageRequest = {
        username: un,
        message: this.message.nativeElement.value
      };

      this.katas.addMessage(messageRequest).subscribe(
        () => {
          this.toastMessageService.showToastMessage('Message added successfully');
          this.reset();
        },
        () => {
          console.log('error');
        }
      );
    }
  }

  reset(): void {
    this.username.nativeElement.value = "";
    this.message.nativeElement.value = "";
  }
}
