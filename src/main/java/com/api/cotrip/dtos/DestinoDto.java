package com.api.cotrip.dtos;


import com.api.cotrip.models.DestinoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties
public class DestinoDto {

    @NotBlank
    private String origem;
    @NotBlank
    private String destino;
    @NotBlank
    private String dataDaIda;
    @NotBlank
    private String dataDaVolta;
    @NotBlank
    private String numeroDePessoas;
    @NotBlank
    private String valorArrecadado;
    @NotBlank
    private String opcoesDeDestino;

    private DestinoModel destino_id;

    public DestinoModel getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(DestinoModel destino_id) {
        this.destino_id = destino_id;
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
}