import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmbalseComponent } from './embalse.component';

describe('EmbalseComponent', () => {
  let component: EmbalseComponent;
  let fixture: ComponentFixture<EmbalseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmbalseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmbalseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
