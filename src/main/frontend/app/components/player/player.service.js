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
            getPlayer: getPlayer,
            getPlayerDetails: getPlayerDetails,
            createPlayer: createPlayer,
            updatePlayer: updatePlayer
        };

        function updatePlayer(playerId, writeRequest) {
            var deferred = $q.defer();
            $http.put(REST_SERVICE_URI + playerId, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while updating player: ' + error);
                    }
                );
            return deferred.promise;
        }

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

        function getPlayer(playerId) {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + playerId)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting player: ' + error);
                    }
                );
            return deferred.promise;
        }

        function getPlayerDetails(playerId) {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + playerId + '/details')
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting player details: ' + error);
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