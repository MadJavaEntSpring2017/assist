(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('playerView', {
            controller: PlayerViewController,
            controllerAs: 'vm',
            template: 'components/player/player-view.html',
            bindings: {},
            require: {}
        });

    PlayerViewController.$inject = [];

    function PlayerViewController() {
        var vm = this;
    }
})();