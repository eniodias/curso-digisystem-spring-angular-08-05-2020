package br.com.digisystem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Pedido;

@Repository
public interface  PedidoRepository extends JpaRepository< Pedido, Integer >{

}
