package com.stefanini.hackaton.rest.DAO;

import com.stefanini.hackaton.rest.entidades.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Integer>{
    public PessoaDAO(){
        super(Pessoa.class);
    }
}
