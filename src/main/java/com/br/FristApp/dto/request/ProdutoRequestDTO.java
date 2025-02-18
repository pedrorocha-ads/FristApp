package com.br.FristApp.dto.request;

public class ProdutoRequestDTO {
    private String nome;
    private double preco;
    private String numeroSerie;

    //Quando se trata de desenvolvimento web, se torna indicado ter dois construtores, um com todos os atributos e outro vazio

    public ProdutoRequestDTO(String nome, double preco, String numeroSerie) {
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = numeroSerie;
    }
    public ProdutoRequestDTO() { //Construtor Vazio // Acessar metodos da classe sem precisar construir objetos

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
