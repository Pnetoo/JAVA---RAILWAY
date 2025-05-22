package org.acme.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RELATO")
public class Relato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relato_seq")
    @SequenceGenerator(name = "relato_seq", sequenceName = "SQ_TBRELATO", allocationSize = 1)
    @Column(name = "ID_RELATO")
    private Long id;

    @Lob
    @Column(name = "DS_RELATO", nullable = false)
    private String descricao;

    @Column(name = "TP_URGENCIA", nullable = false, length = 20)
    private String tipoUrgencia;

    @Column(name = "DT_HORA")
    private LocalDateTime dataHora;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "ID_ESTACAO", nullable = false)
    private Long idEstacao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoUrgencia() {
        return tipoUrgencia;
    }

    public void setTipoUrgencia(String tipoUrgencia) {
        this.tipoUrgencia = tipoUrgencia;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Long idEstacao) {
        this.idEstacao = idEstacao;
    }

}