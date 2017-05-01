(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('seasonService', seasonService);

    seasonService.$inject = ['apiService'];

    function seasonService(apiService) {
        return {
            getAllSeasons: getAllSeasons,
            getSeasonDetails: getSeasonDetails,
            createSeason: createSeason,
            updateSeason: updateSeason
        };

        function getAllSeasons() {
            return apiService.get('/seasons');
        }

        function getSeasonDetails(seasonId) {
            return apiService.get('/seasons/' + seasonId + '/details');
        }

        function createSeason(writeRequest) {
            return apiService.post('/seasons', writeRequest);
        }

        function updateSeason(seasonId, writeRequest) {
            return apiService.put('/seasons/' + seasonId, writeRequest);
        }
    }
})();