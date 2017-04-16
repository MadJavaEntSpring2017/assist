(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('teamService', teamService);

    teamService.$inject = ['$log', '$q', '$http'];

    function teamService($log, $q, $http) {
        var vm = this;
        var REST_SERVICE_URI = 'http://localhost:8000/teams';

        $log.debug(vm);

        return {
            getAllTeam: getAllTeams
        };
        
        function getAllTeams() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting teams.');
                        $log.debug(error);
                    }
                );
            return deferred.promise;
        }
    }
})();