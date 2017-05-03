(function () {
    'use strict';
    angular
        .module('assist-web')
        .component('roster', {
            controller: RosterController,
            controllerAs: 'vm',
            templateUrl: 'components/roster/roster.html',
            bindings: {
                roster: '<'
            },
            require: {}
        });

    RosterController.$inject = ['$q', 'teamService', 'sessionService'];

    function RosterController($q, teamService, sessionService) {
        var vm = this;

        vm.save = save;
        vm.selectTeam = selectTeam;
        vm.selectSession = selectSession;

        function selectSession(event) {
            vm.roster.session = event.session;
        }

        function selectTeam(event) {
            vm.roster.team = event.team;
        }

        function save() {
            console.log('saving roster...'); // todo delete
        }

        vm.$onInit = function () {
            $q.all({
                team: vm.roster ? teamService.getTeam(vm.roster.teamId) : {},
                session: vm.roster ? sessionService.getSessionDetails(vm.roster.sessionId) : {}
            }).then(function (results) {
                vm.team = results.team;
                vm.session = results.session;
            });
        };
    }
})();