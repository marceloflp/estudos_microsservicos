package br.com.marceloflp.pedidos.notificacao.listener;

import br.com.marceloflp.pedidos.notificacao.entities.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidosListener {

    private final Logger logger = LoggerFactory.getLogger(PedidosListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    private void enviarNotificacao(Pedido pedido){
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}
