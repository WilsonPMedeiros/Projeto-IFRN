import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;

public class FuncaoStep {
    public FuncaoStep() {
        @Dado("que acessei a página de cadastro de funcao")
                public void queAcesseiAPaginaDeCadastroDeFuncao(){

        }

        @Quando() Quando("^informo o nome \"([^\"]*)\"$", (String arg0) -> { });
        @E() E("^informo o salario \"([^\"]*)\"$", (String arg0) -> { });
        @E() E("^clico no botao Salva$", () -> { });
        @Então() Então("^sera exibida a pagina \"([^\"]*)\"$", (String arg0) -> { });
    }
}
