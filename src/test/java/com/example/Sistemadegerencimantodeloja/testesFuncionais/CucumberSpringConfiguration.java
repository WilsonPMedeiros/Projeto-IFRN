package com.example.Sistemadegerencimantodeloja.testesFuncionais;


import com.example.Sistemadegerencimantodeloja.SistemaDeGerencimantoDeLojaApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@SpringBootTest
//@SpringBootTest(classes = {SmartestoqueApplication.class,
//        Runner.class},
//        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SistemaDeGerencimantoDeLojaApplication.class,
        loader = AnnotationConfigContextLoader.class
)

public class CucumberSpringConfiguration {
}
