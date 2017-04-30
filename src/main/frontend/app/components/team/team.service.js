(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('teamService', teamService);

    teamService.$inject = ['apiService'];

    function teamService(apiService) {

        return {
            getAllTeams: getAllTeams,
            getTeam: getTeam,
            createTeam: createTeam,
            updateTeam: updateTeam
        };

        function updateTeam(teamId, writeRequest) {
            return apiService.put('/teams/' + teamId, writeRequest);
        }

        function createTeam(writeRequest) {
            return apiService.post('/teams', writeRequest);
        }

        function getTeam(teamId) {
            return apiService.get('/teams/' + teamId);
        }
        
        function getAllTeams() {
            return apiService.get('/teams');
        }
    }
})();