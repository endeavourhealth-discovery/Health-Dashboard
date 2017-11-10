import {Observable} from 'rxjs/Observable';
import {Chart} from 'angular-highcharts';

export class Ticker {
  id: number;
  title: string;
  refresh: number;
  chart: Chart;
  timer: Observable<number>;
}
