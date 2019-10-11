package com.stefanini.hackaton.rest.persistence;

import com.stefanini.hackaton.rest.entidades.Conta;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class RepositorioConta {
    private Map<Integer, Conta> mapConta = new HashMap<>();

    public Map<Integer, Conta> getMapConta() {
        return mapConta;
    }

    public void deletar(Integer id){
        mapConta.remove(id);
    }

    public Conta atualizarMapConta(Integer key, Conta conta){

        mapConta.put(key, conta);
        return mapConta.get(conta.getId());
    }

    public List<Conta> findAgencia(final String agencia){

        final List<Conta> listConta = new ArrayList<>();

        System.out.println(mapConta.size());

        mapConta.forEach((key, conta) ->{
            if(conta.getAgencia().equals(agencia)) {
                listConta.add(conta);
            }
        });

        return listConta;
    }

}
