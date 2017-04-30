(function () {
    'use strict';
    angular
        .module('assist-web')
        .factory('playerService', playerService);

    playerService.$inject = ['apiService'];

    function playerService(apiService) {

        return {
            getAllPlayers: getAllPlayers,
            getPlayerDetails: getPlayerDetails,
            createPlayer: createPlayer,
            updatePlayer: updatePlayer
        };

        function updatePlayer(playerId, writeRequest) {
            return apiService.put('/players/' + playerId, writeRequest);
        }

        function createPlayer(writeRequest) {
            return apiService.post('/players', writeRequest);
        }

        function getPlayerDetails(playerId) {
            return apiService.get('/players/' + playerId + '/details');
        }

        function getAllPlayers() {
            return apiService.get('/players');
        }
    }
})();