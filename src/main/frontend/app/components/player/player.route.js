(function () {
    'use strict';
    angular
        .module('assist-web')
        .config(playerRouteConfig);

    playerRouteConfig.$inject = ['$stateProvider'];

    function playerRouteConfig($stateProvider) {
        var playerListState = {
            name: 'main.players',
            url: '/players',
            component: 'playerList',
            resolve: {
                players: function (playerService) {
                    return playerService.getAllPlayers();
                }
            }
        };

        var playerDetailState = {
            name: 'main.player-details',
            url: '/players/:playerId/details',
            component: 'player',
            resolve: {
                player: function (playerService, $stateParams) {
                    return playerService.getPlayerDetails($stateParams.playerId);
                }
            }
        };

        var playerAddState = {
            name: 'main.players-add',
            url: '/players/add',
            component: 'player'
        };

        $stateProvider
            .state(playerListState)
            .state(playerDetailState)
            .state(playerAddState);
    }
})();