import { Component, OnInit } from '@angular/core';
import {Ticker} from '../models/Ticker';
import {TickerService} from './ticker.service';
import {Observable} from 'rxjs/Observable';
import {Chart} from 'angular-highcharts';

@Component({
  selector: 'app-ticker',
  templateUrl: './ticker.component.html',
  styleUrls: ['./ticker.component.css']
})
export class TickerComponent implements OnInit {
  tickers: Ticker[];

  constructor(private tickerService: TickerService) { }

  ngOnInit() {
    this.loadTickers();
  }

  loadTickers() {
    const vm = this;
    vm.tickerService.getTickers()
      .subscribe(
        (result) => vm.createTickerGraphs(result),
        (error) => console.error(error)
      );
  }

  createTickerGraphs(tickers: Ticker[]) {
    this.tickers = tickers;
    const vm = this;
    for (const ticker of tickers) {
      ticker.timer = Observable.timer(0, ticker.refresh * 1000);
      ticker.timer.subscribe(
        (ticks) => vm.loadTickerData(ticker),
        (error) => console.error(error)
      );
    }
  }

  loadTickerData(ticker: Ticker) {
    const vm = this;
    ticker.chart = null;
    vm.tickerService.loadTickerData(ticker.id)
      .subscribe(
        (result) => vm.buildChart(ticker, result),
        (error) => console.error(error)
      );
  }

  buildChart(ticker: Ticker, chartData: any) {
    ticker.chart = new Chart({
      title: { text: ticker.title },
      chart: { animation: false },
      credits: { enabled: false },
      plotOptions: { series: { animation: false }},
      series: chartData.series,
      xAxis: {categories: chartData.xAxis}
    });
  }
}
