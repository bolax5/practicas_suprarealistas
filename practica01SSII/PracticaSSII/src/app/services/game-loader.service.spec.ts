import { TestBed, inject } from '@angular/core/testing';

import { GameLoaderService } from './game-loader.service';

describe('GameLoaderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GameLoaderService]
    });
  });

  it('should be created', inject([GameLoaderService], (service: GameLoaderService) => {
    expect(service).toBeTruthy();
  }));
});
