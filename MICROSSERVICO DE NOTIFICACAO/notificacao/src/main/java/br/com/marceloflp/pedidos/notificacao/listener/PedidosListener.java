package br.com.marceloflp.pedidos.notificacao.listener;

import br.com.marceloflp.pedidos.notificacao.entities.Pedido;
import br.com.marceloflp.pedidos.notificacao.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidosListener {

    private final Logger logger = LoggerFactory.getLogger(PedidosListener.class);
    private final EmailService emailService;

    public PedidosListener(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    private void enviarNotificacao(Pedido pedido){

        logger.info("Tentando consumir a mensagem");
        if(pedido.getValorTotal() > 2000){
            throw new RuntimeException("Valor acima do limite");
        }
        emailService.enviaEmail(pedido);
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}
