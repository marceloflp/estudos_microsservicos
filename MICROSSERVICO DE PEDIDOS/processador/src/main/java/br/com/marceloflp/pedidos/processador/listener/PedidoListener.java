package br.com.marceloflp.pedidos.processador.listener;

import br.com.marceloflp.pedidos.processador.entities.Pedido;
import br.com.marceloflp.pedidos.processador.entities.enums.Status;
import br.com.marceloflp.pedidos.processador.services.PedidoService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final PedidoService pedidoService;

    public PedidoListener(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido){
        pedido.setStatus(Status.PROCESSADO);
        pedidoService.save(pedido);
    }
}
