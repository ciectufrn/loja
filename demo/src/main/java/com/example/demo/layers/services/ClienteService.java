package com.example.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ValidacaoException;
import com.example.demo.layers.entities.Cliente;
import com.example.demo.layers.repositories.ClienteRepository;
import com.example.demo.utils.CPFUtils;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) throws ValidacaoException {

        if(!CPFUtils.isValidCPF(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        return clienteRepository.save(cliente);
    }

}
