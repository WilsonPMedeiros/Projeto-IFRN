package com.example.Sistemadegerencimantodeloja.testesFuncionais.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroFuncaoPage extends BasePage{

    @FindBy(id = "nome")
    private WebElement campoNome;
    @FindBy(name = "salario")
    private WebElement campoSalario;
    @FindBy(tagName = "button")
    private WebElement btnCadastro;

    public CadastroFuncaoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void preencherNome(String nome){
        campoNome.sendKeys(nome);
    }

    public void preencherSalario(String salario){
        campoSalario.sendKeys(salario);
    }
    public void clicarEmCadastrar(){
        btnCadastro.click();
    }

}
