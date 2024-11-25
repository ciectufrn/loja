package com.example.demo.layers.services;

import java.util.Optional;

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

        if(cliente.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(!CPFUtils.isValidCPF(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) throws ValidacaoException {

        if(cliente.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Cliente> _cliente = clienteRepository.findById(cliente.getId());
        if(_cliente.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(!CPFUtils.isValidCPF(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        return clienteRepository.save(cliente);
    }

    public void removerCliente(Long idCliente) throws ValidacaoException  {
        if(idCliente == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Cliente> _cliente = clienteRepository.findById(idCliente);
        if(_cliente.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        clienteRepository.deleteById(idCliente);        
    }

}
