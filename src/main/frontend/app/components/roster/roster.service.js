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
            getRosterDetails: getRosterDetails
        };

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