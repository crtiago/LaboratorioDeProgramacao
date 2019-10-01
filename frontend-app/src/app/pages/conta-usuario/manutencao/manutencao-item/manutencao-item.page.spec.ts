import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManutencaoItemPage } from './manutencao-item.page';

describe('ManutencaoItemPage', () => {
  let component: ManutencaoItemPage;
  let fixture: ComponentFixture<ManutencaoItemPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManutencaoItemPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManutencaoItemPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
