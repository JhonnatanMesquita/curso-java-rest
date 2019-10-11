package com.stefanini.hackaton.rest.parsers;

import com.stefanini.hackaton.rest.DTO.PessoaDTO;
import com.stefanini.hackaton.rest.entidades.Pessoa;

public class PessoaParse extends AbstractParse<Pessoa, PessoaDTO> {

    @Override
    public Pessoa toEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO.getNome());
        return pessoa;
    }

    @Override
    public PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoa.getNome());
        return pessoaDTO;
    }
}
