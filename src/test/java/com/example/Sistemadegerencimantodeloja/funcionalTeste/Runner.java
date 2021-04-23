package com.example.Sistemadegerencimantodeloja.funcionalTeste;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberContextConfiguration
    @CucumberOptions(
            features = "src/test/resources/features"
//        glue = "br.com.eduardohenrique.smartestoque.functionalTests.steps"
    )
//@PropertySource("application.properties")
//@SpringBootTest
    public class Runner{

    }


