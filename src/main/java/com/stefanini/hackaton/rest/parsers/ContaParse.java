package com.stefanini.hackaton.rest.parsers;

import com.stefanini.hackaton.rest.DTO.ContaDTO;
import com.stefanini.hackaton.rest.entidades.Conta;

public class ContaParse extends AbstractParse<Conta, ContaDTO> {

    @Override
    public Conta toEntity(ContaDTO contaDTO) {
        Conta conta = new Conta(contaDTO.getConta(), contaDTO.getAgencia());
        return conta;
    }

    @Override
    public ContaDTO toDTO(Conta conta) {
        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setAgencia(conta.getAgencia());
        contaDTO.setConta(conta.getConta());
        return contaDTO;
    }
}
