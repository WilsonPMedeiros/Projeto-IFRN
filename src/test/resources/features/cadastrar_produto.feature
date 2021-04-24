#language: pt


Funcionalidade: Cadastrar Funcao
  Cenário: Cadastrar funcao com todos os dados
    Dado que acessei a página de cadastro de funcao
    Quando informo o nome "Administrador"
    E informo o salario "100"
    E clico no botao Salva
    Então sera exibida a pagina "Opcoes funcao"
