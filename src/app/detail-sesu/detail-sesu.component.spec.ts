import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailSesuComponent } from './detail-sesu.component';

describe('DetailSesuComponent', () => {
  let component: DetailSesuComponent;
  let fixture: ComponentFixture<DetailSesuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailSesuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailSesuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
