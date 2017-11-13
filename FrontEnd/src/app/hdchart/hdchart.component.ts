import { Component, OnInit } from '@angular/core';
import {HDChart} from '../models/HDChart';
import {HDChartService} from './hdchart.service';
import {Observable} from 'rxjs/Observable';
import {Chart} from 'angular-highcharts';

@Component({
  selector: 'app-hdchart',
  templateUrl: './hdchart.component.html',
  styleUrls: ['./hdchart.component.css']
})
export class HDChartComponent implements OnInit {
  hdCharts: HDChart[];

  constructor(private tickerService: HDChartService) { }

  ngOnInit() {
    this.loadCharts();
  }

  loadCharts() {
    const vm = this;
    vm.tickerService.getCharts()
      .subscribe(
        (result) => vm.createCharts(result),
        (error) => console.error(error)
      );
  }

  createCharts(charts: HDChart[]) {
    this.hdCharts = charts;
    const vm = this;
    for (const chart of charts) {
      chart.timer = Observable.timer(0, chart.refresh * 1000);
      chart.timer.subscribe(
        (ticks) => vm.loadChartData(chart),
        (error) => console.error(error)
      );
    }
  }

  loadChartData(hdChart: HDChart) {
    const vm = this;
    hdChart.chart = null;
    vm.tickerService.loadChartData(hdChart.id)
      .subscribe(
        (result) => vm.buildChart(hdChart, result),
        (error) => console.error(error)
      );
  }

  buildChart(hdChart: HDChart, chartData: any) {
    hdChart.chart = new Chart({
      title: { text: hdChart.title },
      chart: { animation: false },
      credits: { enabled: false },
      plotOptions: { series: { animation: false }},
      series: chartData.series,
      xAxis: {categories: chartData.xAxis}
    });
  }
}
