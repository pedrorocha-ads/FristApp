package com.br.FristApp.service;


import com.br.FristApp.dto.request.ProdutoRequestDTO;
import com.br.FristApp.dto.response.ProdutoResponseDTO;
import com.br.FristApp.model.Produto;
import com.br.FristApp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //indica que é uma classe de serviço pelo SpringBoot
public class ProdutoService {

    private final ProdutoRepository produtoRepository; //cria um objeto do tipo ProdutoRepository

    public ProdutoService(ProdutoRepository produtoRepository) { //construtor
        this.produtoRepository = produtoRepository;
    }
    public List<ProdutoResponseDTO> listarProdutos(){ //lista os produtos
        return produtoRepository.findAll().stream()
                .map(produto -> new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco()))
                .collect(Collectors.toList()); // collection é uma interface que representa um grupo de objetos para que o java possa manipular
    }
    public ProdutoResponseDTO buscarPorID(Long id){ //busca o produto pelo id
        Produto produto =  produtoRepository.findByIdd(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));//caso não encontre o produto, retorna uma exceção
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco());//retorna o produto pelo id, nome e preço
    }
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO){
        Produto novoProduto = new Produto(null, produtoRequestDTO.getNome(), produtoRequestDTO.getPreco(), produtoRequestDTO.getNumeroSerie()); //cria um novo produto
        Produto produtoSalvo = produtoRepository.save(novoProduto); //salva o produto
        return new ProdutoResponseDTO(produtoSalvo.getId(), produtoSalvo.getNome(), produtoSalvo.getPreco()); //retorna o produto salvo
    }
}
