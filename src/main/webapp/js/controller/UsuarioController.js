
myApp.controller('UsuarioController', function UsuarioController
        ($scope, $http, UsuarioFactory) {

    $scope.dados = [{"IdUsuario": 1,
            "IdGrupo": 1,
            "Login": "lbs",
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

})




