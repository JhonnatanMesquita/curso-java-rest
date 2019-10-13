package com.stefanini.hackaton.rest.DAO;

import com.stefanini.hackaton.rest.entidades.Conta;

public class ContaDAO extends GenericDAO<Conta, Integer> {
    public ContaDAO(){
        super(Conta.class);
    }
}
