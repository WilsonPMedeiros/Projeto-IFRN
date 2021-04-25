package com.example.Sistemadegerencimantodeloja.testesFuncionais;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
//@CucumberContextConfiguration
    @CucumberOptions(
            features = "src/test/resources/features"
//        glue = "br.com.eduardohenrique.smartestoque.functionalTests.com.example.Sistemadegerencimantodeloja.testesFuncionais.steps"
    )
//@PropertySource("application.properties")
//@SpringBootTest
    public class Runner{
    }


