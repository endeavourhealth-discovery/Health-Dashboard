import {Observable} from 'rxjs/Observable';
import {Chart} from 'angular-highcharts';

export class HDChart {
  id: number;
  title: string;
  refresh: number;
  chart: Chart;
  timer: Observable<number>;
}
