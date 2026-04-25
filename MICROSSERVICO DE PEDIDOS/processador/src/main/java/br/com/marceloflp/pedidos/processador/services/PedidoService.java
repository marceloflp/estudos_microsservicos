package br.com.marceloflp.pedidos.processador.services;

import br.com.marceloflp.pedidos.processador.entities.ItemPedido;
import br.com.marceloflp.pedidos.processador.entities.Pedido;
import br.com.marceloflp.pedidos.processador.repositories.ItemPedidoRepository;
import br.com.marceloflp.pedidos.processador.repositories.PedidoRepository;
import br.com.marceloflp.pedidos.processador.repositories.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

    public void save(Pedido pedido){
        //salvar produtos
        produtoService.save(pedido.getItemPedidos());

        //salvar itens do pedido
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItemPedidos());

        //salvar pedido
        pedidoRepository.save(pedido);

        //atualiza item pedido definindo o pedido ao qual ele faz parte
        itemPedidoService.updatedItemPedido(itemPedidos, pedido);

        logger.info("Pedido salvo: {}", pedido.toString());
    }
}
