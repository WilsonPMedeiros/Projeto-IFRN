package com.example.Sistemadegerencimantodeloja.model;

import java.util.Objects;

public class VendaAux {
    double valor;
    int quantidade;
   //int  cliente;
    Produtos produto;


    public double getValor() {
        return this.valor;
    }

    public int getQuantidade() {

        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

 //   public int getCliente() {
  //      return cliente;
    //}

    //public void setCliente(int cliente) {
   //    this.cliente = cliente;
  //  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaAux vendaAux = (VendaAux) o;
        return Double.compare(vendaAux.valor, valor) == 0 && quantidade == vendaAux.quantidade  && produto == vendaAux.produto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, quantidade, produto);
    }

    @Override
    public String toString() {
        return "VendaAux{" +
                "valor=" + valor +
                ", quantidade=" + quantidade +
                //", cliente=" + cliente +
                ", produto=" + produto +
                '}';
    }

    public Produtos getProduto() {
        return produto;
    }

  public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
