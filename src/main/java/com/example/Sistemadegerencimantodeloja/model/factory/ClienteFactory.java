package com.example.Sistemadegerencimantodeloja.model.factory;


import com.example.Sistemadegerencimantodeloja.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteFactory {

    public Cliente criarCliente(
            String nome, String cpf, String sexo,
            String email, String telefone) {

        Cliente cliente = Cliente.builder()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .sexo(sexo)
                .telefone(telefone)
                .build();
//        this.repository.save(cliente);
        return cliente;

    }

}
