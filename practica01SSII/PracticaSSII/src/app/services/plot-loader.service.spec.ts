import { TestBed, inject } from '@angular/core/testing';

import { PlotLoaderService } from './plot-loader.service';

describe('PlotLoaderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlotLoaderService]
    });
  });

  it('should be created', inject([PlotLoaderService], (service: PlotLoaderService) => {
    expect(service).toBeTruthy();
  }));
});
