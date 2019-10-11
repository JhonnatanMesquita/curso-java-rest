package com.stefanini.hackaton.rest.DAO;

import com.stefanini.hackaton.rest.entidades.Conta;

import javax.persistence.*;
import java.util.Collection;

public class ContaDAO extends GenericDAO<Conta, Integer> {
    public ContaDAO(){
        super(Conta.class);
    }
}
