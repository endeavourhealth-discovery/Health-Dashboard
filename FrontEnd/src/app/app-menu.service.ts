import {Injectable} from '@angular/core';
import {MenuOption} from 'eds-angular4/dist/layout/models/MenuOption';
import {AbstractMenuProvider} from 'eds-angular4';
import {Routes} from '@angular/router';
import {HDChartComponent} from './hdchart/hdchart.component';

@Injectable()
export class AppMenuService implements  AbstractMenuProvider {
  static getRoutes(): Routes {
    return [
      { path: '', redirectTo : 'ticker', pathMatch: 'full' },
      { path: 'ticker', component: HDChartComponent }
    ]
  }

  getClientId(): string {
    return 'health-dashboard';
  }
  getApplicationTitle(): string {
    return 'Health Dashboard';
  }
  getMenuOptions(): MenuOption[] {
    return [
      {caption: 'Tickers', state: 'tickers', icon: 'fa fa-line-chart', role: 'health-dashboard:tickers'},
    ];
  }
}
