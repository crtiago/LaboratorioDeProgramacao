import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeusPedidosPage } from './meus-pedidos.page';

describe('MeusPedidosPage', () => {
  let component: MeusPedidosPage;
  let fixture: ComponentFixture<MeusPedidosPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeusPedidosPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeusPedidosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
