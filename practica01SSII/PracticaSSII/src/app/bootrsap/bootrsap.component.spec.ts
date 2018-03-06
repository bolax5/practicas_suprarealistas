import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BootrsapComponent } from './bootrsap.component';

describe('BootrsapComponent', () => {
  let component: BootrsapComponent;
  let fixture: ComponentFixture<BootrsapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BootrsapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BootrsapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
