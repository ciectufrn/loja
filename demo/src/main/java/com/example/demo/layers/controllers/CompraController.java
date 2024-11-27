package com.example.demo.layers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layers.services.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/{nomeCliente}")
    public List<Object[]> obterComprasPorCliente(@PathVariable String nomeCliente) {
        return compraService.obterProdutosEDataCompra(nomeCliente);
    }

    @GetMapping("/todas")
    public List<Object[]> obterTodasAsCompras() {
        return compraService.obterTodasAsCompras();
    }
}
