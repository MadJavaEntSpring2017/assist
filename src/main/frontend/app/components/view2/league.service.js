(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('leagueService', leagueService);

    leagueService.$inject = ['$q', '$http'];

    function leagueService($q, $http) {
        var REST_SERVICE_URI = 'http://localhost:8080/leagues/';

        return {
            getAllLeagues: getAllLeagues
        };

        function getAllLeagues() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting leagues.');
                        $log.debug(error);
                    }
                );
            return deferred.promise;
        }
    }
})();