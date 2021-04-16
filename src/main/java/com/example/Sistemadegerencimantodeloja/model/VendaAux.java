package com.example.Sistemadegerencimantodeloja.model;

import java.util.Objects;

public class VendaAux {
    double valor;
    int quantidade;
    int  cliente;
    long produto;

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaAux vendaAux = (VendaAux) o;
        return Double.compare(vendaAux.valor, valor) == 0 && quantidade == vendaAux.quantidade && cliente == vendaAux.cliente && produto == vendaAux.produto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, quantidade, cliente, produto);
    }

    @Override
    public String toString() {
        return "VendaAux{" +
                "valor=" + valor +
                ", quantidade=" + quantidade +
                ", cliente=" + cliente +
                ", produto=" + produto +
                '}';
    }

    public long getProduto() {
        return produto;
    }

    public void setProduto(long produto) {
        this.produto = produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
