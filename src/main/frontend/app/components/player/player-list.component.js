(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('playerList', {
            controller: PlayerListController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player-list.html',
            require: {},
            bindings: {
                players: '<'
            }
        });

    PlayerListController.$inject = [];

    function PlayerListController() {
        var vm = this;
    }
})();