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
            setUsuario: function (callback, usuario) {
                $http({"method": "POST",
                    "url": "/Aprendercrescer/rest/usuario/setusuario",
                    "headers": {"Content-Type": "appication/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
        };
    }]);

