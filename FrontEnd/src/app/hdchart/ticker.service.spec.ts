import { TestBed, inject } from '@angular/core/testing';

import { HDChartService } from './hdchart.service';

describe('HDChartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HDChartService]
    });
  });

  it('should be created', inject([HDChartService], (service: HDChartService) => {
    expect(service).toBeTruthy();
  }));
});
