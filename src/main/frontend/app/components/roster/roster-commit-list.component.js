(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('rosterCommitList', {
            controller: RosterCommitListController,
            controllerAs: 'vm',
            templateUrl: 'components/roster/roster-commit-list.html',
            bindings: {
                commits: '<'
            },
            require: {}
        });

    RosterCommitListController.$inject = [];

    function RosterCommitListController() {
        var vm = this;
    }
})();