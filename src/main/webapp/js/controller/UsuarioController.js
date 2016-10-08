
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
    $scope.editarUsuario = function (item) {
        $scope.editando = true;
        $scope.usuario = angular.copy(item);
    }
    $scope.cadastroUsuario = function (usuario) {
        if (usuario.IdUsuario && usuario.IdUsuario != 0) {
            UsuarioFactory.updateUsuario($scope.callbackCadastroUsuario, usuario);
        } else {
            UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
        }
    }
    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Usuario", "Erro ao Atualizar usuario!", "error");
            } else {
                swal("Usuario", "Erro ao Cadastrar usuario!", "error");
            }
        } else {
            if ($scope.editando == true) {
                swal("Usuario", "Usuario Salvo com Sucesso", "success");
            } else {
                swal("Usuario", "Usuario Cadastrado com Sucesso", "success");
            }
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
        var usuario = {IdUsuario: "", nome: "", Login: "",
            IdGrupo: "", flagInativo: "", senha: ""
        }
        $scope.usuario = usuario;
        $scope.editando = false;
    }
    $scope.deleteUsuario = function (usuario) {
        UsuarioFactory.deleteUsuario($scope.callbackDeleteUsuario, usuario);
    }
    $scope.callbackDeleteUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Usuario", "Erro ao Deletar usuario!", "error");
        } else {
            swal("Usuario", "Usuario Deletado com sucesso", "success");
            $scope.limpaCampos();
            $scope.buscaUsuarios();
        }
    }
})




