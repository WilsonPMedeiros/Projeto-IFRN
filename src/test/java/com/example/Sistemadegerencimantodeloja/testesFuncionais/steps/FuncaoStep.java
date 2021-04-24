package com.example.Sistemadegerencimantodeloja.testesFuncionais.steps;

public class FuncaoStep {
    public FuncaoStep() {
        Dado("^que accesses a página de cadastro de função$", () -> {
        });
        Quando("^informo o nome \"([^\"]*)\"$", (String arg0) -> {
        });
        E("^informo o salario \"([^\"]*)\"$", (String arg0) -> {
        });
        E("^clico no botão Salva$", () -> {
        });
        Então("^será exibida a página \"([^\"]*)\"$", (String arg0) -> {
        });
    }
}
