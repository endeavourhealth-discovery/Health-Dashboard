import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TickerComponent} from './ticker.component';
import {TickerService} from './ticker.service';
import {ControlsModule} from 'eds-angular4';
import {ChartModule} from 'angular-highcharts';

@NgModule({
  imports: [
    CommonModule,
    ControlsModule,
    ChartModule
  ],
  declarations: [
    TickerComponent
  ],
  providers: [
    TickerService
  ]
})
export class TickerModule { }
