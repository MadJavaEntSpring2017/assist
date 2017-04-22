(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('teamService', teamService);

    teamService.$inject = ['$q', '$http'];

    function teamService($q, $http) {
        var REST_SERVICE_URI = 'http://localhost:8080/teams/';

        return {
            getAllTeams: getAllTeams,
            getTeam: getTeam
        };

        function getTeam(teamId) {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + teamId)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting team: ' + error);
                    }
                );
            return deferred.promise;
        }
        
        function getAllTeams() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting teams: ' + error);
                    }
                );
            return deferred.promise;
        }
    }
})();