import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HDChartComponent } from './hdchart.component';

describe('HDChartComponent', () => {
  let component: HDChartComponent;
  let fixture: ComponentFixture<HDChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HDChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HDChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
