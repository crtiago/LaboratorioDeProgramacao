import { TestBed } from '@angular/core/testing';

import { CartItensService } from './cart-itens.service';

describe('CartItensService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CartItensService = TestBed.get(CartItensService);
    expect(service).toBeTruthy();
  });
});
