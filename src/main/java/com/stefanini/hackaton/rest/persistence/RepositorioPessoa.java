package com.stefanini.hackaton.rest.persistence;

import com.stefanini.hackaton.rest.entidades.Pessoa;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class RepositorioPessoa {

    private Map<String, Pessoa> mapPessoa = new HashMap<>();

    public Map<String, Pessoa> getMapPessoa() {
        return mapPessoa;
    }

    public void deleteMapPesso(String key){
        mapPessoa.remove(key);
    }

    public Pessoa atualizarMapPessoa(String key, Pessoa pessoa){

        pessoa.setCpf(key);

        mapPessoa.put(key, pessoa);
        return mapPessoa.get(pessoa.getCpf());
    }
}
