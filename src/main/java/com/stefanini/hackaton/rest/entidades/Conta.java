package com.stefanini.hackaton.rest.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String agencia;

    @Column
    private String conta;

    @Column
    private String senha;

    @OneToMany(mappedBy = "conta", targetEntity = Pessoa.class, fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    private List<Pessoa> pessoas = new ArrayList<>();

    public Conta() {
    }

    public Conta(String agencia, String conta, String senha) {
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
    }

    public Conta(String agencia, String conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
