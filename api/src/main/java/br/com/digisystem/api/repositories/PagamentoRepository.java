package br.com.digisystem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Pagamento;

@Repository
public interface PagamentoRepository extends  JpaRepository< Pagamento, Integer > {

}
