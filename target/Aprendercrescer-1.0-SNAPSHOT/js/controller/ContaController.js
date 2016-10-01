
myApp.controller('ContaController', function ContaController
        ($scope, $http, ContaFactory) {

    $scope.dados = [{"IdConta": 1,
            "Descricao": "Devedor",
            "TipoConta": "Água",
            "Valor": 123.65,
        }];
    $scope.buscaConta = function () {
        ContaFactory.getConta( $scope.callbackConta);
    }
    $scope.callbackConta = function (resposta) {
        $scope.dados = resposta.data;
    }

})

