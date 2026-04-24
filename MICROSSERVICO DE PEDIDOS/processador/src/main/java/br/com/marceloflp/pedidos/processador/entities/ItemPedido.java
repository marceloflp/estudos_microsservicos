package br.com.marceloflp.pedidos.processador.entities;

import br.com.marceloflp.pedidos.processador.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemPedido {

    private UUID id = UUID.randomUUID();
    private Produto produto;
    private Integer quantidade;
}
