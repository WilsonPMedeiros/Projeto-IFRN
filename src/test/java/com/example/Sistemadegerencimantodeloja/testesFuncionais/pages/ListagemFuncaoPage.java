package com.example.Sistemadegerencimantodeloja.testesFuncionais.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

public class ListagemFuncaoPage extends BasePage{
    public ListagemFuncaoPage(WebDriver driver) {
        super(driver);
    }

    public void verificarPagina(String titulo){
        boolean titlePage = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.titleIs(titulo));
        assertThat(titlePage).isTrue();
    }
}
