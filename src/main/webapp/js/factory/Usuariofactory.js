'user strict';

myApp.factory('UsuarioFactory', ['$http', function ($http) {
        return{
            getUsuarios: function (callback) {
                $http({"method": "GET",
                    "url": "/Aprendercrescer/rest/usuario/getusuarios"}).then(
                        function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);

