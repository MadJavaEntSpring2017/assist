(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('teamList', {
            controller: TeamListController,
            controllerAs: 'vm',
            templateUrl: 'components/team/team-list.html',
            bindings: {
                teams: '<'
            },
            require: {}
        });

    TeamListController.$inject = [];

    function TeamListController() {
        var vm = this;
    }
})();