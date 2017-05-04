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

    RosterListController.$inject = ['$state', '$stateParams'];

    function RosterListController($state, $stateParams) {
        var vm = this;

        vm.edit = edit;

        vm.$onInit = function () {
            vm.teamId = $stateParams.teamId;
            vm.sessionId = $stateParams.sessionId;
        };

        function edit(roster) {
            $state.go('main.roster-details', { rosterId: roster.id });
        }
    }
})();