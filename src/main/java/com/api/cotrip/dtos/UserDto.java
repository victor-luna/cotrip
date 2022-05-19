package com.api.cotrip.dtos;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank
    private String CPF;
    @NotBlank
    private String name;
    @NotBlank
    private String tituloCampanha;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String estado;
    @NotBlank
    private String cidade;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTituloCampanha() {
        return tituloCampanha;
    }

    public void setTituloCampanha(String tituloCampanha) {
        this.tituloCampanha = tituloCampanha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
