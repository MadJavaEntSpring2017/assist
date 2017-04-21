(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('playerContainerView', {
            controller: PlayerContainerViewController,
            controllerAs: 'vm',
            templateUrl: 'components/player/player-container-view.html',
            require: {},
            bindings: {}
        });

    PlayerContainerViewController.$inject = [];

    function PlayerContainerViewController() {
        var vm = this;
    }
})();