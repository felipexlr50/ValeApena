package com.example.felipe.valeapena.model;


import java.util.Comparator;

public class Produto implements Comparable<Produto> {

    private double unidade;
    private double valor;
    private String nome;

    public Produto(double unidade, double valor, String nome) {
        this.unidade = unidade;
        this.valor = valor;
        this.nome = nome;
    }

    public double getUnidade() {
        return unidade;
    }

    public void setUnidade(double unidade) {
        this.unidade = unidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRatio() {
        return valor/unidade;
    }

    @Override
    public int compareTo(Produto p) {
        double ratio = this.getRatio();
        double pRatio = p.getRatio();
        return  Double.valueOf(ratio).compareTo(pRatio);
    }

    public static Comparator<Produto> ProdutoRatioComparator = new Comparator<Produto>() {
        @Override
        public int compare(Produto lhs, Produto rhs) {
            return Double.valueOf(lhs.getRatio()).compareTo(rhs.getRatio());
        }
    };
}
