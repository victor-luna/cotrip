package com.api.cotrip.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_COTRIP_DESTINO")
public class DestinoModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false, length = 100)
    private String origem;
    @Column(nullable = false, length = 100)
    private String destino;
    @Column(nullable = false, length = 100)
    private String dataDaIda;
    @Column(nullable = false, length = 100)
    private String dataDaVolta;
    @Column(nullable = false, length = 100)
    private String numeroDePessoas;
    @Column(nullable = false, length = 50)
    private String valorArrecadado;
    @Column(nullable = false, length = 40)
    private String opcoesDeDestino;
    @Column(nullable = false)
    private LocalDateTime dataDeRegistro;



    @ManyToOne
    private DestinoModel destino_id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataDaIda() {
        return dataDaIda;
    }

    public void setDataDaIda(String dataDaIda) {
        this.dataDaIda = dataDaIda;
    }

    public String getDataDaVolta() {
        return dataDaVolta;
    }

    public void setDataDaVolta(String dataDaVolta) {
        this.dataDaVolta = dataDaVolta;
    }

    public String getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(String numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }

    public String getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(String valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
    }

    public String getOpcoesDeDestino() {
        return opcoesDeDestino;
    }

    public void setOpcoesDeDestino(String opcoesDeDestino) {
        this.opcoesDeDestino = opcoesDeDestino;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public DestinoModel getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(DestinoModel destino_id) {
        this.destino_id = destino_id;
    }
}


