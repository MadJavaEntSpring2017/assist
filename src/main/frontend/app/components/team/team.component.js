(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('team', {
            controller: TeamController,
            controllerAs: 'vm',
            templateUrl: 'components/team/team.html',
            bindings: {
                team: '<'
            },
            require: {}
        });

    TeamController.$inject = [];

    function TeamController() {
        var vm = this;
    }
})();