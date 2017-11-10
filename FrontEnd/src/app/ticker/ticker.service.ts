import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Ticker} from '../models/Ticker';
import {URLSearchParams, Http} from '@angular/http';

@Injectable()
export class TickerService {

  constructor(private http: Http) { }

  public getTickers(): Observable<Ticker[]> {
    return this.http.get('api/tickers', {withCredentials: true})
      .map((response) => response.json());
  }

  public loadTickerData(tickerId: number): Observable<any> {
    const params: URLSearchParams = new URLSearchParams();
    params.append('tickerId', tickerId.toString());

    return this.http.get('api/tickers/data', {search: params, withCredentials: true})
      .map((response) => response.json());
  }
}
