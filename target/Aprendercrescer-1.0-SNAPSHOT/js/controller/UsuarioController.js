
myApp.controller('UsuarioController', function UsuarioController
        ($scope, $http, UsuarioFactory) {

    $scope.editando = false;

    $scope.dados = [{"IdUsuario": 1,
            "idgrupo": 1,
            "login": "lbs",
            "nome": "Luciano",
            "Ativo": 'T'
        }];
    $scope.buscaUsuarios = function () {
        UsuarioFactory.getUsuarios(
                $scope.callbackUsuarios);
    }
    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }
    $scope.editarUsuario = function () {
        $scope.editando = !$scope.editando;
    }
    $scope.cadastroUsuario = function (usuario) {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }
    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            //  alert("ERROU");
            swal("Usuario", "Erro ao cadastrar usuario!", "error");
        } else {
            //alert("OK");
            swal("Usuario", "Usuario Cadastrado com Sucesso!", "success");
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
        $scope.usuario.nome = "";
        $scope.usuario.Login = "";
        $scope.usuario.IdGrupo = "";
        $scope.usuario.flagInativo = "";
        $scope.usuario.senha = "";
    }
})




