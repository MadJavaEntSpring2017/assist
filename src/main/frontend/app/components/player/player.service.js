(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('playerService', playerService);

    playerService.$inject = ['$q', '$http'];

    function playerService($q, $http) {
        var REST_SERVICE_URI = 'http://localhost:8080/players/';

        return {
            getAllPlayers: getAllPlayers,
            createPlayer: createPlayer
        };

        function createPlayer(writeRequest) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while creating player: ' + error);
                    }
                );
            return deferred.promise;
        }

        function getAllPlayers() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting players: ' + error);
                    }
                );
            return deferred.promise;
        }
    }
})();