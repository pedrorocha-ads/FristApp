package com.br.FristApp.dto.response;

//Se torna espelho do model mas pode ser modificado

public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private double preco;
    private String numeroSerie;

    public ProdutoResponseDTO(Long id, String nome, double preco, String numeroSerie) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = numeroSerie;
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
    public String getNumeroSerie() {
        return numeroSerie;
    }
}
