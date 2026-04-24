package br.com.marceloflp.pedidos.processador.entities;

import br.com.marceloflp.pedidos.processador.entities.ItemPedido;
import br.com.marceloflp.pedidos.processador.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();
    private String cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "email_notificacao")
    private String emailNotificacao;

    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_PROCESSAMENTO;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();
}
