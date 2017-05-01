(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('sessionService', sessionService);

    sessionService.$inject = ['apiService'];

    function sessionService(apiService) {
        return {
            getAllSessions: getAllSessions,
            getSessionDetails: getSessionDetails,
            createSession: createSession,
            updateSession: updateSession
        };

        function getAllSessions() {
            return apiService.get('/sessions');
        }

        function getSessionDetails(sessionId) {
            return apiService.get('/sessions/' + sessionId + '/details');
        }

        function createSession(writeRequest) {
            return apiService.post('/sessions', writeRequest);
        }

        function updateSession(sessionId, writeRequest) {
            return apiService.put('/sessions/' + sessionId, writeRequest);
        }
    }
})();