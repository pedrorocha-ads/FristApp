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
    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoResponseDTO produtoResponseDTO){
        Produto produtoExistente = produtoRepository.findByIdd(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado")); //caso não encontre o produto, retorna uma exceção
        produtoExistente.setNome(produtoResponseDTO.getNome()); //altera o nome do produto
        produtoExistente.setPreco(produtoResponseDTO.getPreco()); //altera o preço do produto
        // produtoExistente.setNumeroSerie(produtoResponseDTO.getNumeroSerie()); //altera o numero de serie do produto
        Produto produtoAtualizado = produtoRepository.update(produtoExistente); //atualiza o produto
        return new ProdutoResponseDTO(produtoAtualizado.getId(),
                produtoAtualizado.getNome(),
                produtoAtualizado.getPreco()); //retorna o produto atualizado
    }
    public void excluirProduto(Long id){
        produtoRepository.deleteById(id); //deleta o produto pelo id
    }
}
