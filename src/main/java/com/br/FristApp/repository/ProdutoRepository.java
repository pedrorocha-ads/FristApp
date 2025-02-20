package com.br.FristApp.repository;

import com.br.FristApp.model.Produto;
import org.springframework.stereotype.Repository; //acesso a dados
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //indica que é uma classe de serviço pelo SpringBoot
public class ProdutoRepository {
    private static List<Produto> produtos = new ArrayList<>(); //cria uma lista de produtos
    private Long nextId = 1L; //pega o ultimo id do produto e acrescenta mais um para que exista o proximo produto

    public List<Produto> findAll(){ //pesquisa todos os produtos
        return produtos;
    }//Tipo optional significa que pode ou não retornar um valor
    public Optional<Produto> findByIdd(Long id){
        return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst(); //filtra o produto pelo id
    }
    public Produto save(Produto produto){
        produto.setId(nextId++); // '++' acrescenta mais um ao id se não tiver id
        produtos.add(produto); //adiciona o produto
        return produto; //retorna o produto
    }
    public Produto update(Produto produto){
        return produtos.stream() //atualiza o produto
                .filter(Produto -> produto.getId().equals(produto.getId())) //filtra o produto pelo id
                .findFirst() //retorna o primeiro produto
                .map(Produto -> { //mapeia o produto
                    produto.setNome(produto.getNome()); //altera o nome do produto
                    produto.setPreco(produto.getPreco()); //altera o preço do produto
                    produto.setNumeroSerie(produto.getNumeroSerie()); //altera o numero de serie do produto
                    return produto; //retorna o produto
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado")); //caso não encontre o produto, retorna uma exceção
    }

    public void deleteById(Long id){
        produtos.removeIf(produto -> produto.getId().equals(id)); //remove o produto pelo id
    }
}
