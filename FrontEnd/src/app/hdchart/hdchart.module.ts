import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HDChartComponent} from './hdchart.component';
import {HDChartService} from './hdchart.service';
import {ControlsModule} from 'eds-angular4';
import {ChartModule} from 'angular-highcharts';

@NgModule({
  imports: [
    CommonModule,
    ControlsModule,
    ChartModule
  ],
  declarations: [
    HDChartComponent
  ],
  providers: [
    HDChartService
  ]
})
export class HDChartModule { }
