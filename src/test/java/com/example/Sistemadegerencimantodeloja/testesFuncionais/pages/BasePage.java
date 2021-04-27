package com.example.Sistemadegerencimantodeloja.testesFuncionais.pages;

import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public CadastroFuncaoPage navegar(){
        driver.navigate()
                .to("https://gerenciador-lojas.herokuapp.com/cadastrarFuncao");
        assertThat(driver.getTitle()).isEqualTo("Cadastrar Funcao");
        return new CadastroFuncaoPage(driver);
    }
}
