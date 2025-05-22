package org.acme.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALERTA") // Nome da tabela corrigido
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alerta_seq")
    @SequenceGenerator(name = "alerta_seq", sequenceName = "SQ_TBALERTA", allocationSize = 1)
    @Column(name = "ID_ALERTA")
    private Long id;

    @Lob
    @Column(name = "DS_ALERTA", nullable = false) // Nome da coluna corrigido
    private String descricao;

    @Column(name = "TP_URGENCIA", nullable = false, length = 20) // Adicionado nullable e tamanho
    private String tipoUrgencia;

    @Column(name = "DT_HORA")
    private LocalDateTime dataHora;

    @Column(name = "ID_RELATO", nullable = false)
    private Long idRelato;

    // Construtor vazio
    public Alerta() {
    }

    // Construtor customizado
    public Alerta(String descricao, String tipoUrgencia, Long idRelato) {
        this.descricao = descricao;
        this.tipoUrgencia = tipoUrgencia;
        this.idRelato = idRelato;
        this.dataHora = LocalDateTime.now();
    }

}