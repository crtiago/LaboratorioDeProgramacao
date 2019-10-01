import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeusEnderecosPage } from './meus-enderecos.page';

describe('MeusEnderecosPage', () => {
  let component: MeusEnderecosPage;
  let fixture: ComponentFixture<MeusEnderecosPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeusEnderecosPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeusEnderecosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
