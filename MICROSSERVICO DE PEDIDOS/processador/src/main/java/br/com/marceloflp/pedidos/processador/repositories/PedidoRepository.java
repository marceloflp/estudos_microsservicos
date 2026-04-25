package br.com.marceloflp.pedidos.processador.repositories;

import br.com.marceloflp.pedidos.processador.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
