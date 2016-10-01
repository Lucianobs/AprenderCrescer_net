'user strict';

myApp.factory('GrupoFactory', ['$http', function ($http) {
        return{
            getGrupo: function (callback) {
                $http({"method": "GET",
                    "url": "/Aprendercrescer/rest/grupo/getgrupo"}).then(
                        function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);


