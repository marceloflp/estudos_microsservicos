package br.com.marceloflp.pedidos.processador.services;

import br.com.marceloflp.pedidos.processador.entities.ItemPedido;
import br.com.marceloflp.pedidos.processador.entities.Pedido;
import br.com.marceloflp.pedidos.processador.repositories.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itemPedidos) {

        return itemPedidoRepository.saveAll(itemPedidos);
    }

    public void save(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {

        itemPedidos.forEach(item -> {
            item.setPedido(pedido); //informando ao item o seu pedido
            this.save(item);
        });
    }
}
