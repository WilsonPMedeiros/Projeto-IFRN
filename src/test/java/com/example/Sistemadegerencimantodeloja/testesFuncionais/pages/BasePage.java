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
                .to("https://gerenciador-lojas-homolog.herokuapp.com/cadastrarFuncao");
        assertThat("Cadastrar Funcao").isEqualTo(driver.getTitle());
        return new CadastroFuncaoPage(driver);
    }
}
