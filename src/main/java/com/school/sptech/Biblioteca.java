package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa){
            qtdLivros += quantidade;
        }
    }
    public Integer emprestar(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        }
        return null;
    }
    public Integer devolver(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa){
            qtdLivros += quantidade;
            return quantidade;
        }
        return null;
    }
    public Integer desativar(){
        if (ativa){
            Integer qtdAnterior = qtdLivros;
            ativa = false;
            qtdLivros = 0;
            return qtdAnterior;
        }
        return null;
    }
    public void transferir(Biblioteca destino, Integer quantidade){
        if (quantidade != null && this.ativa && destino.ativa && quantidade <= this.qtdLivros){
            destino.qtdLivros += quantidade;
            this.qtdLivros -= quantidade;
        }
    }
    public Boolean reajustarMulta(Double percentual){
        if (percentual != null && percentual > 0){
            multaDiaria += multaDiaria * percentual;
            return true;
        }
        return false;
    }
    public String getNome(){
        return nome;
    }
    public Double getMultaDiaria(){
        return multaDiaria;
    }
    public Integer getQtdLivros(){
        return qtdLivros;
    }
    public Boolean getAtiva(){
        return ativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}

