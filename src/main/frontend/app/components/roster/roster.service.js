(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('rosterService', rosterService);

    rosterService.$inject = ['apiService'];

    function rosterService(apiService) {
        return {
            getAllRosters: getAllRosters,
            getRostersByTeam: getRostersByTeam,
            getRostersBySession: getRostersBySession,
            getRosterDetails: getRosterDetails,
            createRoster: createRoster,
            updateRoster: updateRoster,
            createCommitsForRoster: createCommitsForRoster
        };

        function createCommitsForRoster(rosterId, writeRequest) {
            return apiService.post('/rosters/' + rosterId + '/commits', writeRequest);
        }

        function updateRoster(rosterId, writeRequest) {
            return apiService.put('/rosters/' + rosterId, writeRequest);
        }

        function createRoster(writeRequest) {
            return apiService.post('/rosters', writeRequest);
        }

        function getRosterDetails(rosterId) {
            return apiService.get('/rosters/' + rosterId + '/details');
        }

        function getAllRosters() {
            return apiService.get('/rosters');
        }

        function getRostersBySession(sessionId) {
            return apiService.get('/sessions/' + sessionId + '/rosters');
        }

        function getRostersByTeam(teamId) {
            return apiService.get('/teams/' + teamId + '/rosters');
        }
    }
})();