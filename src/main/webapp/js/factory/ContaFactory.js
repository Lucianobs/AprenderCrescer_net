'user strict';

myApp.factory('ContaFactory', ['$http', function ($http) {
        return{
            getConta: function (callback) {
                $http({"method": "GET",
                    "url": "/Aprendercrescer/rest/conta/getconta"}).then(
                        function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);

