package com.example.felipe.valeapena.model;

/**
 * Created by 1050481413017 on 07/10/2016.
 */
public class Produto {

    private double unidade;
    private double valor;

    public Produto(double unidade, double valor) {
        this.unidade = unidade;
        this.valor = valor;
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
}
