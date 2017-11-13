import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HDChart} from '../models/HDChart';
import {URLSearchParams, Http} from '@angular/http';

@Injectable()
export class HDChartService {

  constructor(private http: Http) { }

  public getCharts(): Observable<HDChart[]> {
    return this.http.get('api/charts', {withCredentials: true})
      .map((response) => response.json());
  }

  public loadChartData(chartId: number): Observable<any> {
    const params: URLSearchParams = new URLSearchParams();
    params.append('chartId', chartId.toString());

    return this.http.get('api/charts/data', {search: params, withCredentials: true})
      .map((response) => response.json());
  }
}
