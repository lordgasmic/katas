import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Observer} from 'rxjs';
import {MessageRequest} from '../model/MessageRequest';
import {FollowerRequest} from '../model/FollowerRequest';
import {MessageResponse} from '../model/MessageResponse';

@Injectable({
  providedIn: 'root'
})
export class KataService {

  private readonly API = "http://localhost:8080/api/v1";

  constructor(private http:HttpClient) { }

  addMessage(messageRequest: MessageRequest):Observable<void> {
    return new Observable((observer: Observer<void>) => {
      this.http.put<string[]>(this.API + "/message", messageRequest).subscribe(
        () => {
          observer.next();
          observer.complete();
        },
        (err) => {
          observer.error(err);
        }
      );
    });
  }

  addFollower(followerRequest: FollowerRequest):Observable<void> {
    return new Observable((observer: Observer<void>) => {
      this.http.put<string[]>(this.API + "/follower", followerRequest).subscribe(
        () => {
          observer.next();
          observer.complete();
        },
        (err) => {
          observer.error(err);
        }
      );
    });
  }

  getMessages(username: string): Observable<MessageResponse[]>{
    return new Observable((observer: Observer<MessageResponse[]>) => {
      this.http.get<MessageResponse[]>(this.API + `/messages/${username}`).subscribe(
        (feedResponse) => {
          observer.next(feedResponse);
          observer.complete();
        },
        (err) => {
          observer.error(err);
        }
      );
    });
  }

  getWall(username: string):Observable<MessageResponse[]>{
    return new Observable((observer: Observer<MessageResponse[]>) => {
      this.http.get<MessageResponse[]>(this.API + `/wall/${username}`).subscribe(
        (feedResponse) => {
          observer.next(feedResponse);
          observer.complete();
        },
        (err) => {
          observer.error(err);
        }
      );
    });
  }
}


