package br.com.marceloflp.pedidos.processador.services;

import br.com.marceloflp.pedidos.processador.entities.ItemPedido;
import br.com.marceloflp.pedidos.processador.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItemPedido> itemPedidos) {

        itemPedidos.forEach(itemPedido -> {
            produtoRepository.save(itemPedido.getProduto());
        });

    }
}
