(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('rosterList', {
            controller: RosterListController,
            controllerAs: 'vm',
            templateUrl: 'components/roster/roster-list.html',
            bindings: {
                rosters: '<'
            },
            require: {}
        });

    RosterListController.$inject = ['$state'];

    function RosterListController($state) {
        var vm = this;

        vm.edit = edit;

        function edit(roster) {
            $state.go('main.roster-details', { rosterId: roster.id });
        }
    }
})();