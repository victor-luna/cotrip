package com.api.cotrip.models;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_COTRIP_USUARIO")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    @Type(type="uuid-char")
    private UUID id;
    @Column(nullable = false, unique = true, length = 16)
    private String CPF;
    @Column(nullable = false, length = 120)
    private String name;
    @Column(nullable = false, length = 120)
    private String tituloCampanha;
    @Column(nullable = false, length = 80)
    private String email;
    @Column(nullable = false, length = 30)
    private String senha;
    @Column(nullable = false, length = 25)
    private String estado;
    @Column(nullable = false, length = 40)
    private String cidade;
    @Column(nullable = false)
    private LocalDateTime dataDeRegistro;

    @OneToMany(mappedBy = "destino_id", cascade = CascadeType.ALL)
    private List<DestinoModel> destinos = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public List<DestinoModel> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<DestinoModel> destinos) {
        this.destinos = destinos;
    }
}
