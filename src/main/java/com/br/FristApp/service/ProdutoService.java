package com.br.FristApp.service;


import com.br.FristApp.dto.response.ProdutoResponseDTO;
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
                .map(produto -> new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getNumeroSerie()))
                .collect(Collectors.toList()); // collection é uma interface que representa um grupo de objetos para que o java possa manipular
    }
}
