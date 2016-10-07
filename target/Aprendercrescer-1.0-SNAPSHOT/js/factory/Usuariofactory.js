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
            deletUsuario: function (callback, id) {
                $http({"method": "GET",
                    "url": "/Aprendercrescer/rest/usuario/deleteusuarios/" + id}).then(
                        function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);

