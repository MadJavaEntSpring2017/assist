(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('playerView', {
            controller: PlayerViewController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player-view.html',
            require: {},
            bindings: {}
        });

    PlayerViewController.$inject = [];

    function PlayerViewController() {
        var vm = this;
    }
})();