package com.example.Sistemadegerencimantodeloja.testesFuncionais;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features"
)

public class Runner{
}


