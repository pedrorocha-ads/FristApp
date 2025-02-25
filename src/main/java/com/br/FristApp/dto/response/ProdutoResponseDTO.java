package com.br.FristApp.dto.response;

//Se torna espelho do model mas pode ser modificado

public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private double preco;

    public ProdutoResponseDTO(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    public ProdutoResponseDTO() {

    }

    //Apenas os gets pq so vai ter retorno

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
}
