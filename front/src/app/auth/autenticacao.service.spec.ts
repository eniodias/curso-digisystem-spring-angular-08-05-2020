import { TestBed } from '@angular/core/testing';

import { AutenticacaoService } from './services/autenticacao.service';

describe('AutenticacaoService', () => {
  let service: AutenticacaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutenticacaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
