package com.example.Sistemadegerencimantodeloja.testesFuncionais.steps;

import com.example.Sistemadegerencimantodeloja.testesFuncionais.CucumberSpringConfiguration;
import com.example.Sistemadegerencimantodeloja.testesFuncionais.pages.CadastroFuncaoPage;
import com.example.Sistemadegerencimantodeloja.testesFuncionais.pages.ListagemFuncaoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Profile;

public class MyStepdefs extends CucumberSpringConfiguration {

    private WebDriver driver;
    private CadastroFuncaoPage cadastroFuncaoPage;
    private ListagemFuncaoPage listagemFuncaoPage;

    @Before
    @Profile("dev")
    public void iniciar(){
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        this.driver = new ChromeDriver(options);
        this.cadastroFuncaoPage = new CadastroFuncaoPage(this.driver);
    }

    @After
    public void finalizar(){
        this.driver.quit();
    }

    @Dado("que acessei a página de cadastro de funcao")
    public void queAcesseiAPáginaDeCadastroDeFuncao() {
        this.cadastroFuncaoPage.navegar();
    }

    @Quando("informo o nome {string}")
    public void informoONome(String arg0) {
        this.cadastroFuncaoPage.preencherNome(arg0);
        
    }

    @E("informo o salario {string}")
    public void informoOSalario(String arg0) {
        this.cadastroFuncaoPage.preencherSalario(arg0);
        
    }

    @E("clico no botao Salva")
    public void clicoNoBotaoSalva() {
        this.cadastroFuncaoPage.clicarEmCadastrar();
    }

    @Então("sera exibida a pagina {string}")
    public void seraExibidaAPagina(String arg0) {

        listagemFuncaoPage = new ListagemFuncaoPage(driver);
        listagemFuncaoPage.verificarPagina(arg0);

    }
}
