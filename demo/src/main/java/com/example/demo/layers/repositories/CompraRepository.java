package com.example.demo.layers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.layers.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query(value = "SELECT produto.nome AS produto, compra.data AS data_compra " +
                   "FROM cliente " +
                   "JOIN compra ON cliente.id = compra.cliente_id " +
                   "JOIN compra_produto ON compra.id = compra_produto.compra_id " +
                   "JOIN produto ON compra_produto.produto_id = produto.id " +
                   "WHERE cliente.nome = :nome", nativeQuery = true)
    List<Object[]> findProdutosAndDataCompraByClienteNome(@Param("nome") String nome);

}