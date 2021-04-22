 function addCliente(){
    var id=$("#clienteId");
    var nome=$("#clienteNome").val();
    var cpf=$("#clienteCPF");
    var email=$("#clienteEmail");
        $("#nomeInput").val(nome);
        alert("teste", nome);
 }

  function addFuncionario(idFunc){
   idFunc = (typeof idFunc !== 'undefined') ? idFunc : 1;
    return idFunc;

  }

  $(document).on("click", ".cliente", function(){
            var idFuncionario= $(this).find("#cId").text();
             $("#nomeInputCliente").val(idFuncionario);
        });

 $(document).on("click", ".funcionario", function(){
          var idFuncionario= $(this).find("#fId").text();
           $("#nomeInputFuncionario").val(idFuncionario);
      });

 $(document).on("click", ".funcaoFuncionario", function(){
          var idFuncao= $(this).find("#fId").text();
           $("#funcao").val(idFuncao);
      });



  $(document).on("click", ".produto", function(){
          var idProduto = $(this).find("#pId").text();
           $("#nomeInputProduto").val(idProduto);
      });

