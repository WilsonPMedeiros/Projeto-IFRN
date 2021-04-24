package com.example.Sistemadegerencimantodeloja.testesFuncionais.steps;

import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Profile;

public class FuncaoCadastroStep {
    public FuncaoCadastroStep() {
        @Before
        @Profile("dev")
        public void iniciar(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver");
            ChromeOptions options = new ChromeOptions().setHeadless(true);
            options.addArguments("--no-sandbox");
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            this.driver = new ChromeDriver(options);
            this.cadastroProdutoPage = new CadastroProdutoPage(this.driver);
        }

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

    private void Dado(String s, Object o) {
    }
}
