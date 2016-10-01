
myApp.controller('GrupoController', function GrupoController
        ($scope, $http, GrupoFactory) {

    $scope.dados = [{"IdGrupo": 1,
            "TipoUsuario": "A",
            "DescricaoGrupo": "Administradores",
           
        }];
    $scope.buscaGrupo = function () {
        GrupoFactory.getGrupo(
                $scope.callbackGrupo);
    }
    $scope.callbackGrupo = function (resposta) {
        $scope.dados = resposta.data;
    }

})

