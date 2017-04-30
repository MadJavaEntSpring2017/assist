(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('splitService', splitService);

    splitService.$inject = ['$q', '$http'];

    function splitService($q, $http) {
        var REST_SERVICE_URI = 'http://localhost:8080/splits/';

        return {
            getAllSplits: getAllSplits,
            getSplitDetails: getSplitDetails,
            updateSplit: updateSplit,
            createSplit: createSplit
        };

        function createSplit(writeRequest) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while creating split: ' + error);
                    }
                );
            return deferred.promise;
        }

        function updateSplit(splitId, writeRequest) {
            var deferred = $q.defer();
            $http.put(REST_SERVICE_URI + splitId, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while updating split: ' + error);
                    }
                );
            return deferred.promise;
        }

        function getSplitDetails(splitId) {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI + splitId + '/details')
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting split details: ' + error);
                    }
                );
            return deferred.promise;
        }

        function getAllSplits() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject('Error while getting splits: ' + error);
                    }
                );
            return deferred.promise;
        }
    }
})();