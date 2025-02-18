package com.br.FristApp.repository;

import com.br.FristApp.model.Produto;
import org.springframework.stereotype.Repository; //acesso a dados
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private static List<Produto> produtos = new ArrayList<>();
    private Long nextId = 1L; //pega o ultimo id do produto e acrescenta mais um para que exista o proximo produto

    public List<Produto> findAll(){ //pesquisa todos os produtos
        return produtos;
    }//Tipo optional significa que pode ou não retornar um valor
    public Optional<Produto> findByIdd(Long id){
        return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst();
    }
}
