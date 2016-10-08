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
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
            updateUsuario: function (callback, usuario) {
                $http({"method": "POST",
                    "url": "/Aprendercrescer/rest/usuario/updateusuario",
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
            deleteUsuario: function (callback, usuario) {
                $http({"method": "DELETE",
                    "url": "/Aprendercrescer/rest/usuario/deleteusuario",
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
        };
    }]);

