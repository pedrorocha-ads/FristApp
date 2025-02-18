package com.br.FristApp.model;

public class Produto {
    private Long id;  //suporta mais caracteres que o int
    private String nome;
    private double preco; //precisão melhor na parte de moedas, sendo melhor do que o float
    private String numeroSerie;

    //Quando se trata de desenvolvimento web, se torna indicado ter dois construtores, um com todos os atributos e outro vazio

    public Produto(Long id, String nome, double preco, String numeroSerie) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = numeroSerie;
    }
    public Produto() { // Construtor Vazio // Acessar metodos da classe sem precisar construir objetos

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
