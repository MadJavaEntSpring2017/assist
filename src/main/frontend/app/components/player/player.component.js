(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('player', {
            controller: PlayerController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player.html',
            bindings: {
                player: '<'
            },
            require: {}
        });

    PlayerController.$inject = [];

    function PlayerController() {
        var vm = this;
    }
})();