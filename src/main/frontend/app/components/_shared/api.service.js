(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('apiService', apiService);

    apiService.$inject = ['$q', '$http'];

    function apiService($q, $http) {
        var BASE_URI = 'http://13.58.92.16:8080/assist';
        // var BASE_URI = 'http://localhost:8080/assist';
        var REST_SERVICE_URI;

        return {
            get: get,
            post: post,
            put: put
        };

        function put(path, writeRequest) {
            buildUri(path);
            var deferred = $q.defer();
            $http.put(REST_SERVICE_URI, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject(error);
                    }
                );
            return deferred.promise;
        }

        function post(path, writeRequest) {
            buildUri(path);
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI, writeRequest)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject(error);
                    }
                );
            return deferred.promise;
        }

        function get(path) {
            buildUri(path);
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI)
                .then(
                    function (results) {
                        deferred.resolve(results.data);
                    },
                    function (error) {
                        deferred.reject(error);
                    }
                );
            return deferred.promise;
        }

        function buildUri(path) {
            REST_SERVICE_URI = BASE_URI + path;
        }
    }
})();